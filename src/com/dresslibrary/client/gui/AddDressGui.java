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
				
				addForm.submit();
			}
			
		});
		
	}	
	
	
}

