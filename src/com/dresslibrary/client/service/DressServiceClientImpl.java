package com.dresslibrary.client.service;

import java.util.ArrayList;

import com.dresslibrary.client.gui.AddDressGui;
import com.dresslibrary.client.gui.CreateUserGui;
import com.dresslibrary.client.gui.DressGui;
import com.dresslibrary.client.model.DressCategory;
import com.dresslibrary.client.model.DressImages;
import com.dresslibrary.client.model.DressInfo;
import com.dresslibrary.client.model.LibraryUser;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.ServiceDefTarget;
import com.google.gwt.user.client.ui.Widget;

public class DressServiceClientImpl implements DressServiceClient{
	private DressServiceAsync service; 
	private DressGui gui; 
	private CreateUserGui newUserGui;
	private AddDressGui addDressGui; 

	public DressServiceClientImpl(String url){
		System.out.println("Url: " + url);
		this.service = GWT.create(DressService.class);
		ServiceDefTarget endPoint = (ServiceDefTarget) this.service; 
		endPoint.setServiceEntryPoint(url);
		gui = new DressGui(this);

		newUserGui = new CreateUserGui(this);

		addDressGui = new AddDressGui(this);


	}

	public DressServiceClientImpl(){
		
	}

	@Override
	public void getDressInfo(int imageID) {
		this.service.getDressInfo(imageID, new DressCallback());

	}

	@Override
	public void getDressImages() {
		this.service.getDressImages(new DressCallback());

	}

	public DressGui getGui(){
		return gui; 
	}

	public void getAllCategories() {
		this.service.getAllCategories(new DressCallback());

	}
	

	public void getSelectedDressImages(String s) {
		this.service.getSelectedDressImages(s, new DressCallback());
	}
	
	public Widget getCreateNewUserGui() {
		return newUserGui;
	}
	
	public Widget getAddDressGui() {
		return addDressGui;
	}
	
	public void createNewUser(LibraryUser lu, String text) {
		this.service.createNewUser(lu, text, new AsyncCallback(){

			@Override
			public void onFailure(Throwable caught) {
				Window.alert("Något har gått fel, error error");
				
			}

			@Override
			public void onSuccess(Object result) {
				LibraryUser lu = (LibraryUser) result; 
				newUserGui.displayNewUser(lu);
			}
			
		});
	}
	
	public void login(String userName, String password) {
		this.service.logIn(userName, password, new AsyncCallback(){

			@Override
			public void onFailure(Throwable caught) {
				Window.alert("Något har gått fel, error error");
				
			}

			@Override
			public void onSuccess(Object result) {
				LibraryUser lu = (LibraryUser) result;
				gui.displayLoginInfo(lu);
				
			}
			
		});
		
	}

	
	public void loanEnquiry(LibraryUser currentUser) {
		
	}
	
	private class DressCallback implements AsyncCallback {

		@Override
		public void onFailure(Throwable caught) {
			System.out.println("Något har gått fel, error error");

		}

		@Override
		public void onSuccess(Object result) {
			if(result instanceof String){
				String message = (String) result; 
				gui.updateGui(message);
			} else if(result instanceof DressInfo){
				DressInfo info = (DressInfo) result; 
				gui.dispayDressInfo(info);
			} else if(result instanceof DressImages ){
				DressImages images = (DressImages) result; 
				gui.dispayDresses(images);
			} else if(result instanceof LibraryUser){
				LibraryUser lu = (LibraryUser) result; 
				gui.dispayUserInfo(lu);	
			} else if(result instanceof DressCategory){
				DressCategory cat = (DressCategory) result;
				gui.setAllCategories(cat);
			}
		}

	}

	

}





