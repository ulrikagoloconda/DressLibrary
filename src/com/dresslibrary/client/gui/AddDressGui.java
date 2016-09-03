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
	private AddDressForm addForm;
	private Button submit; 
	private TextBox categoryText; 
	private Label  categoryLabel; 
	private String fileName; 
	private TextBox sizeText; 
	private Label sizeLabel; 
	private TextBox locationText; 
	private Label locationLabel; 
	private TextBox stateText; 
	private Label stateLabel; 
	private TextBox ownerDescriptonText;
	private Label ownerDescritionLabel;
	
	private static VerticalPanel mainPanel; 
	private Button okButton; 
	
	public AddDressGui(DressServiceClientImpl dressServiceClientImpl){
		this.dressServiceClientImpl = dressServiceClientImpl;
		initAddDressGui();
		initWidget(this.mainPanel);

	}

	public void initAddDressGui(){
		mainPanel = new VerticalPanel();
		addForm = new AddDressForm();
		
		submit = new Button("Ladda upp");
		okButton = new Button("Ok");
		mainPanel.add(addForm);
		mainPanel.add(submit);
		mainPanel.add(okButton);
		categoryText = new TextBox(); 
		categoryLabel = new Label(); 
	 
		sizeText = new TextBox();; 
		sizeLabel = new Label(); 
		locationText = new TextBox();; 
		locationLabel = new Label(); 
		 stateText = new TextBox(); 
		stateLabel =  new Label(); 
	ownerDescriptonText = new TextBox();
		ownerDescritionLabel = new Label(); 
		mainPanel.add(categoryLabel);
		mainPanel.add(categoryText);
		mainPanel.add(sizeLabel);
		mainPanel.add(sizeText);
		mainPanel.add(locationLabel);
		mainPanel.add(locationText);
		mainPanel.add(stateLabel);
		mainPanel.add(stateText);
		mainPanel.add(ownerDescritionLabel);
		mainPanel.add(ownerDescriptonText);


		
		submit.addStyleName("buttonClass");
		okButton.addStyleName("buttonClass");
		
okButton.setEnabled(false);
		okButton.addClickHandler(new ClickHandler(){

			@Override
			public void onClick(ClickEvent event) {
				DressLibrary.viewMainGui();
			}
			
		});
		submit.addClickHandler(new ClickHandler(){

			@Override
			public void onClick(ClickEvent event) {
				fileName = addForm.getFileName();
				addForm.submit();
			
				okButton.setEnabled(true);
			}
			
		});
		
	}	
	private void setDressInfoObject(){
		
	}
	public void setFileName(String fileName){
		this.fileName = fileName; 
	}
	
	
}

