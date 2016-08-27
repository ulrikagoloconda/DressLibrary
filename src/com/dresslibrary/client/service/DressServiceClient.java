package com.dresslibrary.client.service;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface DressServiceClient {
	 void getDressInfo(int imageID);
	void getDressImages();
	void login(String userName, String password);

}
