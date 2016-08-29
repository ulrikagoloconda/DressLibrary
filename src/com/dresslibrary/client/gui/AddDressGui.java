package com.dresslibrary.client.gui;

import com.dresslibrary.client.DressLibrary;
import com.dresslibrary.client.service.DressServiceClientImpl;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class AddDressGui extends Composite{
	private DressServiceClientImpl dressServiceClientImpl; 
	private static String fileNameString; 
	private AddDressForm addForm;
	private Button submit; 
	private VerticalPanel mainPanel; 
	private Button okButton; 
	private Label fileNameLabel; 
	private static TextBox fileName; 
	public AddDressGui(DressServiceClientImpl dressServiceClientImpl){
		this.dressServiceClientImpl = dressServiceClientImpl;
Window.alert("först");
		initAddDressGui();
		Window.alert("efter");

		initWidget(this.mainPanel);

	}

	public void initAddDressGui(){
		mainPanel = new VerticalPanel();
		addForm = new AddDressForm();
		Window.alert("hit också ");
		submit = new Button("Ladda upp");
		okButton = new Button("Ok");
		fileName = new TextBox();
		fileNameLabel = new Label("Filnamn");
		
		
		mainPanel.add(fileNameLabel);
		mainPanel.add(fileName);
		mainPanel.add(addForm);
		mainPanel.add(submit);
		mainPanel.add(okButton);
		
		submit.addStyleName("buttonClass");
		okButton.addStyleName("buttonClass");

		okButton.addClickHandler(new ClickHandler(){

			@Override
			public void onClick(ClickEvent event) {
				DressLibrary.viewMainGui();
			}
			
		});
		submit.addClickHandler(new ClickHandler(){

			@Override
			public void onClick(ClickEvent event) {
				
				addForm.submit();
			}
			
		});
		
	}	
	
	public static String getFileName(){
		fileNameString = fileName.getText();
		return fileNameString; 
		
	}
}

