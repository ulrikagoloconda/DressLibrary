package com.dresslibrary.client.gui;

import java.util.Iterator;

import com.dresslibrary.client.service.DressServiceClientImpl;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.FileUpload;
import com.google.gwt.user.client.ui.FormPanel;
import com.google.gwt.user.client.ui.TextBox;

public class AddDressForm extends FormPanel{
	private DressServiceClientImpl dressServiceClientImpl;
	private FileUpload upload; 
	private String fileName; 


	public AddDressForm(){
		initGui();
		
		this.setAction(GWT.getModuleBaseURL()+"fileupload");
		this.setEncoding(FormPanel.ENCODING_MULTIPART);
		this.setMethod(FormPanel.METHOD_POST);
		this.add(upload);
		addSubmitHandler();

	
	}


		public void initGui(){
			upload = new FileUpload();
			upload.setName("Temp");
			
		}

		public void addSubmitHandler(){

			this.addSubmitHandler(new SubmitHandler(){

				@Override
				public void onSubmit(SubmitEvent event) {

					if (5>10) {
						event.cancel();
					}
				}

			});

			this.addSubmitCompleteHandler(new SubmitCompleteHandler(){

				@Override
				public void onSubmitComplete(SubmitCompleteEvent event) {
					fileName = upload.getFilename();
					Window.alert("event get Results "+event.getResults());
					event.getResults();

				}

			});
			
		}


		public String getFileName() {
			return fileName;
		}



		
	}
	


