package com.dresslibrary.client.gui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.dresslibrary.client.DressLibrary;
import com.dresslibrary.client.model.DressCategory;
import com.dresslibrary.client.model.DressImages;
import com.dresslibrary.client.model.DressInfo;
import com.dresslibrary.client.model.LibraryUser;
import com.dresslibrary.client.service.DressServiceClientImpl;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class DressGui extends Composite{
	private DressServiceClientImpl dressServiceClientImpl;
	private VerticalPanel vPanel;
	private Label loginInfo;
	private TextBox textBox;
	private Button loginButton;
	private Button imagesButton;
	private Label messageLabel;
	private Label calcLabel;
	private HorizontalPanel imagePanel;
	private ArrayList<HorizontalPanel> imagePanelList; 
	private Map<Integer, Image> imageIDMap;
	private HTML html;
	private Button getButton;
	private LibraryUser currentUser; 
	private Label userLabel;
	private Map<Integer, LibraryUser> tempConnection;
	private HorizontalPanel loginPanel;
	private Label dressInfoLabel;
	private Label searchLabel;
	private HorizontalPanel searchPanel;
	private ArrayList<String> allCategories; 
	private DressInfo currentDress;
	private TextBox searchBox;
	private Button searchButton;
	private Label searchInfoLabel;
	private PasswordTextBox password; 
	private Label passwordLabel; 
	private Button newUser; 
	private Button addDress; 
	
	public DressGui(DressServiceClientImpl dressServiceClientImpl){
		initGui();
		initWidget(this.vPanel);
		this.dressServiceClientImpl = dressServiceClientImpl; 


		vPanel.add(loginPanel);
		vPanel.add(loginButton);
		vPanel.add(newUser);
		vPanel.add(searchPanel);
		vPanel.add(imagePanel);
		vPanel.add(dressInfoLabel);

		loginButton.addClickHandler(new LoginButtonHandler());
		imagesButton.addClickHandler(new ImagesButtonHandler());
		getButton.addClickHandler(new LendHandler());
		searchButton.addClickHandler(new SearchHandler());
		newUser.addClickHandler(new NewUserHandler() );
		addDress.addClickHandler(new AddDressToLibraryHandler());



		loginButton.setStyleName("buttonClass");
		getButton.setStyleName("buttonClass");
		imagesButton.setStyleName("buttonClass");
		loginInfo.setStyleName("overallText");
		messageLabel.setStyleName("overallText");
		textBox.setStyleName("textBox");
		password.setStyleName("textBox");
		searchBox.setStyleName("textBox");
		dressInfoLabel.setStyleName("overallText");
		userLabel.setStyleName("overallText");
		searchButton.setStyleName("buttonClass");
		searchLabel.setStyleName("overallText");
		searchInfoLabel.setStyleName("overallText");
		passwordLabel.setStyleName("overallText");
		newUser.setStyleName("buttonClass");
		addDress.setStyleName("buttonClass");
		


		loginPanel.add(loginInfo);
		loginPanel.add(textBox);
		loginPanel.add(passwordLabel);
		loginPanel.add(password);
		loginPanel.add(messageLabel);


		searchLabel.setVisible(false);
		searchBox.setVisible(false);
		searchButton.setVisible(false);
		imagesButton.setVisible(false);
		dressInfoLabel.setVisible(false);
		searchInfoLabel.setVisible(false);
		addDress.setVisible(false);


		searchPanel.add(imagesButton);
		searchPanel.add(searchLabel);
		searchPanel.add(searchBox);
		searchPanel.add(searchButton);
		searchPanel.add(searchInfoLabel);
		searchPanel.add(addDress);
	}


	public void initGui(){
		vPanel = new VerticalPanel();
		loginInfo = new Label("Ditt anv\u00e4ndarnam: ");
		textBox = new TextBox();
		loginButton = new Button("Logga in h\u00e4r");
		imagesButton = new Button("Visa alla plagg");
		messageLabel = new Label("");
		calcLabel  = new Label ("Calc ");
		imagePanel = new HorizontalPanel();
		imagePanelList = new ArrayList();
		imageIDMap = new HashMap<>();
		html = new HTML();
		getButton = new Button("L\u00e5na plagget");
		currentUser = new LibraryUser(); 
		userLabel = new Label();
		tempConnection = new HashMap<>();
		loginPanel = new HorizontalPanel();
		dressInfoLabel = new Label("Klicka p\u00e5 bilderna f\u00f6r mer information");
		searchLabel = new Label("S\u00f6k p\u00e5 valfri kategor: ");
		searchPanel = new HorizontalPanel();
		searchBox = new TextBox();
		searchButton = new Button("S\u00f6k");
		searchInfoLabel = new Label();
		password = new PasswordTextBox();
		passwordLabel = new Label("Ditt l\u00f6senord: ");
		newUser = new Button("Skapa konto");
		addDress = new Button("L\u00e4gg till plagg till bibliotek");

	}


	public void updateGui(String message){
		textBox.setVisible(false);
		loginInfo.setVisible(false);
		loginButton.setVisible(false);
		messageLabel.setText(message);
		getAllCategories();
		imagesButton.setVisible(true);
		searchLabel.setVisible(true);
		searchBox.setVisible(true);
		searchButton.setVisible(true);

	}

	public HorizontalPanel getNewPanel(){
		return new HorizontalPanel();
	}

	public void dispayDresses(DressImages images){
		for(HorizontalPanel p : imagePanelList){
			p.clear();
		}
		imagePanelList.clear();

		Map<Integer,String> idPath = images.getIdPathList();
		int count = 0;
		HorizontalPanel panel = null; 
		for(Map.Entry<Integer, String> entry : idPath.entrySet()){
			if(count == 0){
				panel = getNewPanel();
				imagePanelList.add(panel);
			}

			Image im = new Image(entry.getValue());
			imageIDMap.put(entry.getKey(), im);
			im.setWidth("150px");
			im.setHeight("200px");
			im.addClickHandler(new ImageHandler());
			panel.add(im);
			count++;
			if(count==6){
				count = 0; 
			}
		}
		for(HorizontalPanel hp : imagePanelList){
			vPanel.add(hp);
		}
		dressInfoLabel.setVisible(true);
	}



	public void dispayDressInfo(DressInfo info){
		currentDress = info;
		html.setHTML("");
		String s = "<b>Category: </b> " + info.getCategory() + "</br>";

		s = s + "<b>Size: </b> " + info.getSize() + "</br>";
		s = s + "<b>State: </b> " + info.getState() + "</br>";
		s = s + "<b>Location: </b> " + info.getLocation() + "</br>";
		if(info.getComments().size() > 0){
			s = s + "<b>User comment: </b>" + info.getComments().get(0) + "</br>";
		}
		if(info.isAvailable()){
			s = s + "<b>Available: </b> " + "Yes";
		} else {
			s = s + "<b>Available: </b> " + "No";

		}

		html.setHTML(s);
		vPanel.add(html);
		vPanel.add(getButton);
		getButton.setVisible(true);
		tempConnection.put(info.getImageID(), currentUser);


	}


	public void dispayUserInfo(LibraryUser lu) {
		userLabel.setText("");
		if(!currentDress.isAvailable()){
			String available = "Detta plagg \u00e4r tyv\u00e4rr upptaget f\u00f6r n\u00e4rvarande";
			userLabel.setText(available);
		}else if(lu.getRate() > 2){
			String yes = "Grattis " + lu.getfName() + " du har betyg " + lu.getRate() + " och kan allts\u00e5 l\u00e5na plagget!";
			userLabel.setText(yes);
			currentDress.setAvailable(false);
			dispayDressInfo(currentDress);
		} else if (lu.getRate() <= 2){
			String no = "Sorry " + lu.getfName() + " du har betyg " + lu.getRate() + " och kan d\u00e4rf\u00f6r inte l\u00e5naplagget.";
			userLabel.setText(no);
		}
		vPanel.add(userLabel);
	}

	public void getAllCategories(){
		dressServiceClientImpl.getAllCategories();
	}


	public void setAllCategories(DressCategory cat) {

		allCategories = cat.getDressCategoryList(); 		
	}

	public void displayLoginInfo(LibraryUser lu) {
		currentUser = lu; 
		textBox.setVisible(false);
		loginInfo.setVisible(false);
		loginButton.setVisible(false);
		newUser.setVisible(false);
		passwordLabel.setVisible(false);
		password.setVisible(false);
		messageLabel.setText("V\u00e4lkommen " + lu.getfName()+ "!");
		getAllCategories();
		imagesButton.setVisible(true);
		searchLabel.setVisible(true);
		searchBox.setVisible(true);
		searchButton.setVisible(true);
		addDress.setVisible(true);

	} 	


	private class LoginButtonHandler implements ClickHandler {

		@Override
		public void onClick(ClickEvent event) {

			dressServiceClientImpl.login(textBox.getText(), password.getText());
					
		}

	}

	private class ImagesButtonHandler implements ClickHandler {

		@Override
		public void onClick(ClickEvent event) {
			dressServiceClientImpl.getDressImages();

		}

	}

	private class ImageHandler implements ClickHandler {

		@Override
		public void onClick(ClickEvent event) {
			userLabel.setText("");
			Image i = (Image)event.getSource();
			for(Entry<Integer, Image> entry : imageIDMap.entrySet()){
				if(entry.getValue().equals(i)){
					int j = entry.getKey();
					dressServiceClientImpl.getDressInfo(j);

				}	
			}
		}
	}

	private class LendHandler implements ClickHandler {


		@Override
		public void onClick(ClickEvent event) {
			Image i = (Image)event.getSource();
			i.setStyleName("clickedImage");
			for(Entry<Integer, Image> entry : imageIDMap.entrySet()){
				if(entry.getValue().equals(i)){
					entry.getKey();
					
				}
			}
			
			dressServiceClientImpl.loanEnquiry(currentUser);
		}
	}

	
	private class SearchHandler implements ClickHandler {

		@Override
		public void onClick(ClickEvent event) {
			html.setText("");
			getButton.setVisible(false);
			searchInfoLabel.setText("");
			String s = searchBox.getText();
			if(allCategories.contains(s)){
				dressServiceClientImpl.getSelectedDressImages(s);
			} else {
				searchInfoLabel.setVisible(true);
				searchInfoLabel.setText("Tyv\u00e4rr finns inget plagg i den kategori du valt att s\u00f6ka p\u00e5. F\u00f6rs\u00f6k med \"Tr\u00f6ja\", \"Byxa\" eller \"Kl\u00e4nning\"" );
				
			}
		}

	}
	
	private class NewUserHandler implements ClickHandler {

		@Override
		public void onClick(ClickEvent event) {
			DressLibrary.viewCreateNewUserGui();
		
		}
		
	}
	
	private class AddDressToLibraryHandler implements ClickHandler {

		@Override
		public void onClick(ClickEvent event) {
			DressLibrary.viewAddDressGui();
		}

	}

	
}

