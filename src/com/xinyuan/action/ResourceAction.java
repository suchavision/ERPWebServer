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

		try {
			
			ServletInputStream stream = request.getInputStream();

			File file = new File("/Users/isaacs/Desktop/camera.png");
			OutputStream os = null;
			try {
				os = new FileOutputStream(file);
				byte buffer[] = new byte[4 * 1024];
				while ((stream.read(buffer)) != -1) {
					os.write(buffer);
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
