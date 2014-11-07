package com.modules.Util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {

		String boudary = "OSJpZihvYiRnUmpiXGxWQTpAJHJnWlFWeCxKNTRq";

		String endBoundary = "------" + boudary + "--";

		String contentTypeString = "Content-Type";

		String newLineCharacter = "\r\n";

		StringBuilder builder = new StringBuilder();

		File file = new File("/Users/zhukun/Desktop/camera.txt");

		File dataFile = new File("/Users/zhukun/Desktop/realTemp.txt");

		FileOutputStream outputStream = new FileOutputStream(dataFile);

		FileInputStream fileInputStream = new FileInputStream(file);

		boolean foundTheRealData = false;

		byte buffer[] = new byte[50];
		while (fileInputStream.read(buffer) != -1) {

			String string = new String(buffer);

			System.out.println(string);

			builder.append(string);

			if (foundTheRealData) {
				
				if (!string.equals(endBoundary)) {
					
					outputStream.write(buffer);
				}
				
			} else if (builder.indexOf(contentTypeString) != -1) {
				if (builder.indexOf(newLineCharacter) != -1) {

					String lastString = new String(buffer);
					int newLineIndex = lastString.indexOf(newLineCharacter);

					int offset = newLineIndex + 2;
					int len = buffer.length - offset; 
					

					foundTheRealData = true;
					outputStream.write(buffer, offset, len);
				}
			}

		}
		outputStream.flush();

	}
	
//	{
//	new FileOutputStream(f).getChannel().truncate(0).close(); } catch (IOException e) { /* log and ignore */ }
//	
//	
//	FileChannel outChanaaa = new FileOutputStream("/Users/zhukun/Desktop/realTemp.txt", true).getChannel();
//	outChanaaa.truncate(3000);
//	outChanaaa.close();
	

}
