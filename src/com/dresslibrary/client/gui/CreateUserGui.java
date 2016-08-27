package com.dresslibrary.client.gui;

import com.dresslibrary.client.DressLibrary;
import com.dresslibrary.client.model.LibraryUser;
import com.dresslibrary.client.service.DressServiceClientImpl;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class CreateUserGui extends Composite{

	DressServiceClientImpl dressServiceClientImpl;

	private VerticalPanel mainPanel;

	private TextBox userNameBox;
	private TextBox fNameBox;
	private TextBox lNameBox;
	private TextBox emailBox;
	private PasswordTextBox passwordBox; 
	private Label userNameLabel; 
	private Label fNameLabel; 
	private Label lNameLabel;
	private Label emailLabel; 
	private Label passwordLabel;
	private Button createButton; 
	private Button confermButton; 
	public CreateUserGui(DressServiceClientImpl dressServiceClientImpl){
		initCreateGui();
		initWidget(this.mainPanel);
		this.dressServiceClientImpl = dressServiceClientImpl; 


		mainPanel.add(userNameLabel);
		mainPanel.add(userNameBox);

		mainPanel.add(fNameLabel);
		mainPanel.add(fNameBox);
		mainPanel.add(lNameLabel);
		mainPanel.add(lNameBox);

		mainPanel.add(emailLabel);
		mainPanel.add(emailBox);

		mainPanel.add(passwordLabel);
		mainPanel.add(passwordBox);
		mainPanel.add(createButton);

	}

	public void initCreateGui(){
		mainPanel = new VerticalPanel();
		userNameBox = new TextBox();
		fNameBox = new TextBox();;
		lNameBox = new TextBox();;
		emailBox = new TextBox();;
		passwordBox = new PasswordTextBox(); 
		userNameLabel = new Label("Anv\u00e5ndarnam: "); 
		fNameLabel = new Label("F\u00f6rnamn: "); 
		lNameLabel = new Label("Efernamn: ");
		emailLabel = new Label("Epost: "); 
		passwordLabel = new Label("L\u00f6senord: ");
		createButton = new Button("Skapa kontot");
		confermButton = new Button("Ok!");
		
		createButton.addClickHandler(new CreateButtonHandler());
		confermButton.addClickHandler(new ConfirmHandler());
		

		userNameBox.setStyleName("textBox");
		fNameBox.setStyleName("textBox");
		lNameBox.setStyleName("textBox");
		emailBox.setStyleName("textBox");
		passwordBox.setStyleName("textBox");
		userNameLabel.setStyleName("overallText");
		fNameLabel.setStyleName("overallText");
		lNameLabel.setStyleName("overallText");
		emailLabel.setStyleName("overallText");
		passwordLabel.setStyleName("overallText");
		createButton.setStyleName("buttonClass");
		confermButton.setStyleName("buttonClass");

	}

	
	public void displayNewUser(LibraryUser lu) {
		HTML html = new HTML();
		String s = "<b>V\u00e5lkommen till Dress Library " + lu.getfName() + "!</b> <br>";
		s = s + "<b>Namn: "+ lu.getfName() + "</b><br>";
		s = s + "<b>Efternamn: "+ lu.getlName() + "</b><br>";
		s = s + "<b>E-post: "+ lu.getEmail() + "</b><br>";
		s = s + "<b>Anv\u00e4ndarnamn: "+ lu.getUserNamne() + "</b><br>";

		html.setHTML(s);
		mainPanel.add(html);



	}
	
	
	private class CreateButtonHandler implements ClickHandler {

		@Override
		public void onClick(ClickEvent event) {
			LibraryUser lu = new LibraryUser();
			lu.setfName(fNameBox.getText());
			lu.setlName(lNameBox.getText());
			lu.setEmail(emailBox.getText());
			lu.setUserNamne(userNameBox.getText());
			lu.setKarma(10);
			lu.setRate(3);
			lu.setNumberOfDelays(0);
			dressServiceClientImpl.createNewUser(lu, passwordBox.getText());
			createButton.setEnabled(false);
			mainPanel.add(confermButton);
		}

	}
	
	
	private class ConfirmHandler implements ClickHandler {

		@Override
		public void onClick(ClickEvent event) {
			DressLibrary.viewMainGui();

		}
		
		
	}


	

}

