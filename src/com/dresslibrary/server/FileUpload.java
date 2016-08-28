package com.dresslibrary.server;


import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet; 
import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse; 
import org.apache.commons.fileupload.FileItemIterator; 
import org.apache.commons.fileupload.FileItemStream; 
import org.apache.commons.fileupload.servlet.ServletFileUpload;
//import org.apache.commons.io.output.ByteArrayOutputStream; 

public class FileUpload extends HttpServlet{
	
    public void doPost(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
    	System.out.println("Om detta körs så är det en stor framgång iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii");
        ServletFileUpload upload = new ServletFileUpload();

        try{
            FileItemIterator iter = upload.getItemIterator(request);

            while (iter.hasNext()) {
                FileItemStream item = iter.next();

                String name = item.getFieldName();
                System.out.println(name + " 00000000000000000000000000000000000000000000000000000000000000000000000");
                InputStream stream = item.openStream();


                // Process the input stream
                ByteArrayOutputStream out = new ByteArrayOutputStream();
                int len;
                byte[] buffer = new byte[8192];
                while ((len = stream.read(buffer, 0, buffer.length)) != -1) {
                    out.write(buffer, 0, len);
                }

             
                
                int maxFileSize = 10*(1024*1024); //10 megs max 
                if (out.size() > maxFileSize) { 
                    throw new RuntimeException("File is > than " + maxFileSize);
                }
                
                
                try(OutputStream outputStream = new FileOutputStream("thefilename")) {
                    out.writeTo(outputStream);
                }
                
                out
            }
        }
        catch(Exception e){
            throw new RuntimeException(e);
        }

    }
}

/*
 <servlet>
    <servlet-name>fileUploaderServlet</servlet-name>
    <servlet-class>com.dresslibrary.server.FileUpload</servlet-class>
</servlet>
<servlet-mapping>
  <servlet-name>fileUploaderServlet</servlet-name>
  <url-pattern>/fileupload</url-pattern>
</servlet-mapping>
*/