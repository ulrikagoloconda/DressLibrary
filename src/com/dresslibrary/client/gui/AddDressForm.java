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
	private String tempName; 


	public AddDressForm(){
		Window.alert("vad händer i addDressForm");
		initGui();
		Window.alert("vad händer i addDressForm");
		
		this.setAction(GWT.getModuleBaseURL()+"fileupload");
		this.setEncoding(FormPanel.ENCODING_MULTIPART);
		this.setMethod(FormPanel.METHOD_POST);
		

		//upload.setName(AddDressGui.getFileName());
		this.add(upload);
		Window.alert("vad händer i addDressForm");

		addSubmitHandler();

	
	}


		public void initGui(){
			upload = new FileUpload();
		}

		public void addSubmitHandler(){

			this.addSubmitHandler(new SubmitHandler(){

				@Override
				public void onSubmit(SubmitEvent event) {

					if (10<5) {
						event.cancel();
					}
				}

			});

			this.addSubmitCompleteHandler(new SubmitCompleteHandler(){

				@Override
				public void onSubmitComplete(SubmitCompleteEvent event) {
					Window.alert(event.getResults());

				}

			});
			
		}


		public String getTempName() {
			return tempName;
		}


		public void setTempName(String tempName) {
			this.tempName = tempName;
		}
		
	}
	


