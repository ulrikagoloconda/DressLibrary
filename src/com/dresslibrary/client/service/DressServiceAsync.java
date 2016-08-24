package com.dresslibrary.client.service;

import java.util.ArrayList;

import com.dresslibrary.client.model.DressImages;
import com.dresslibrary.client.model.LibraryUser;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface DressServiceAsync {
	 void welcome(String name, AsyncCallback callback);
	 void calcualte(int num1, int num2, AsyncCallback callback);
	 void getDressInfo(int imageID, AsyncCallback callback);
	void getDressImages(AsyncCallback callback);
	void getUserInfo(String name, AsyncCallback callback);
	void getAllCategories(AsyncCallback callback);
	void getSelectedDressImages(String s, AsyncCallback callback);
}
