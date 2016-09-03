package com.dresslibrary.server;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import MySQLDatabase.DBConnection;
import MySQLDatabase.Test;

public class FileUpload extends HttpServlet{
	DBConnection db = new DBConnection();

	public void doPost(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
System.out.println("Körs detta i doPost");
		ServletFileUpload upload = new ServletFileUpload();
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		if(isMultipart){
			System.out.println("Körs detta i doPost");

			try{
				System.out.println("Körs detta i doPost");


				FileItemIterator iter = upload.getItemIterator(request);
				while (iter.hasNext()) {
					FileItemStream item = iter.next();

					String name = item.getFieldName();
					InputStream stream = item.openStream();

					ByteArrayOutputStream out = new ByteArrayOutputStream();
					int len;
					byte[] buffer = new byte[8192];
					while ((len = stream.read(buffer, 0, buffer.length)) != -1) {
						out.write(buffer, 0, len);
					}


					int maxFileSize = 10*(1024*1024); 
					if (out.size() > maxFileSize) { 
						throw new RuntimeException("Filen är större än " + maxFileSize);
					}
					
				byte[] byteArray=out.toByteArray();
				ByteArrayInputStream inputStream = new ByteArrayInputStream(byteArray);
				System.out.println("Körs detta efter byteArrayinput");
				db.connectToDB();
				 int i = db.insertIntoDressImage(inputStream, item.getName());
				 System.out.println(i + " genererat id");
				 request.setAttribute(""+i, new Object());
				}
			}
			catch(Exception e){
				throw new RuntimeException(e);
			}

		}
		
	}
}
