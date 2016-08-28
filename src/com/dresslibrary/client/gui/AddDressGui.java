package com.dresslibrary.client.gui;

import java.util.Iterator;

import com.dresslibrary.client.service.DressServiceClientImpl;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FileUpload;
import com.google.gwt.user.client.ui.FormPanel;
import com.google.gwt.user.client.ui.FormPanel.SubmitCompleteEvent;
import com.google.gwt.user.client.ui.FormPanel.SubmitCompleteHandler;
import com.google.gwt.user.client.ui.FormPanel.SubmitEvent;
import com.google.gwt.user.client.ui.FormPanel.SubmitHandler;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

public class AddDressGui extends FormPanel{
	private DressServiceClientImpl dressServiceClientImpl;
	//private VerticalPanel mainPanel;
	//private FormPanel form;
	private TextBox sizeBox; 
	//private ListBox categoryBox; 
	
	private FileUpload upload; 
	//private Button submit; 



	public AddDressGui(DressServiceClientImpl dressServiceClientImpl){
		initGui();
		//initWidget(this.mainPanel);
		this.dressServiceClientImpl = dressServiceClientImpl; 
		Window.alert(GWT.getModuleBaseURL()+"fileupload");
		this.setAction(GWT.getModuleBaseURL()+"fileupload");
	//	this.setAction("/myFormHandler");
		this.setEncoding(FormPanel.ENCODING_MULTIPART);
		this.setMethod(FormPanel.METHOD_POST);
		//.setWidget(mainPanel); Behövs kanske göras nån annanstans
		

		sizeBox.setName("sizeTextBoxForm");
		//categoryBox.setName("categoreyBox");
		upload.setName("uploadDress");

		//categoryBox.addItem("foo", "fooValue");
		//categoryBox.addItem("bar", "barValue");
		//categoryBox.addItem("baz", "bazValue");

		//this.add(sizeBox);
		//mainPanel.add(categoryBox);
		this.add(upload);
		
		addSubmitHandler();

	
	}


		public void initGui(){
			upload = new FileUpload();
			sizeBox = new TextBox();
			//categoryBox = new ListBox();
			//submit = new Button("L\u00e4gg till plagg");
		}

		public void addSubmitHandler(){

			this.addSubmitHandler(new SubmitHandler(){

				@Override
				public void onSubmit(SubmitEvent event) {
					Window.alert("i submit ");

					if (10<5) {
						event.cancel();
					}
				}

			});

			this.addSubmitCompleteHandler(new SubmitCompleteHandler(){

				@Override
				public void onSubmitComplete(SubmitCompleteEvent event) {
					Window.alert(event.getResults());

					Window.alert("i submit complete");
				}

			});
			
		}
		

	}
	


