package com.dresslibrary.client.service;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface DressServiceClient {
	 void welcome(String name);
	 void calcualte(int num1, int num2);
	 void getDressInfo(int imageID);
	void getDressImages();
	void getUserInfo(String currentUser);

}
