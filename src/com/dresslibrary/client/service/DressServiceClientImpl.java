package com.dresslibrary.client.service;

import java.util.ArrayList;

import com.dresslibrary.client.gui.DressGui;
import com.dresslibrary.client.model.DressCategory;
import com.dresslibrary.client.model.DressImages;
import com.dresslibrary.client.model.DressInfo;
import com.dresslibrary.client.model.LibraryUser;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.ServiceDefTarget;

public class DressServiceClientImpl implements DressServiceClient{
	private DressServiceAsync service; 
	private DressGui gui; 

	public DressServiceClientImpl(String url){
		System.out.println("Url: " + url);
		this.service = GWT.create(DressService.class);
		ServiceDefTarget endPoint = (ServiceDefTarget) this.service; 
		endPoint.setServiceEntryPoint(url);
		gui = new DressGui(this);
	}

	@Override
	public void welcome(String name) {
		this.service.welcome(name, new DressCallback());

	}

	@Override
	public void calcualte(int num1, int num2) {
		this.service.calcualte(num1, num2, new DressCallback());
	}


	@Override
	public void getDressInfo(int imageID) {
		this.service.getDressInfo(imageID, new DressCallback());

	}

	@Override
	public void getDressImages() {
		this.service.getDressImages(new DressCallback());

	}


	public void getUserInfo(String currentUser) {
		this.service.getUserInfo(currentUser, new DressCallback());
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





