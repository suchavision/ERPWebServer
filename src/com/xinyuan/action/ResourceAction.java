package com.xinyuan.action;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class ResourceAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	public String upload() throws Exception {
		
		HttpServletRequest request = ServletActionContext.getRequest();
		String boundary = request.getHeader("boundary");
		

		try {
			
			ServletInputStream stream = request.getInputStream();

			File file = new File("/Users/zhukun/Desktop/camera.txt");
			OutputStream os = null;
			try {
				os = new FileOutputStream(file);
				byte buffer[] = new byte[4 * 1024];
				
				int count = 0;
				
				while ((stream.read(buffer)) != -1) {
					String s=boundary.substring(0,6);	
				}
				os.flush();
			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return Action.NONE;
	}

	
}
