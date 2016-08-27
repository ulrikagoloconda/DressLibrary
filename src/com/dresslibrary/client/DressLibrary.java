package com.dresslibrary.client;

import java.util.ArrayList;

import com.dresslibrary.client.service.DressServiceClientImpl;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class DressLibrary implements EntryPoint {
private static DressServiceClientImpl serviceClient; 

	public void onModuleLoad() {
		serviceClient = new DressServiceClientImpl(GWT.getModuleBaseURL()+ "dresservice");
		RootPanel.get("compositElement").add(serviceClient.getGui());
		
	}
	
	public static void viewCreateNewUserGui(){
		RootPanel.get("compositElement").clear();
		RootPanel.get("compositElement").add(serviceClient.getCreateNewUserGui());
	}
	
	public static void viewMainGui(){
		RootPanel.get("compositElement").clear();
		RootPanel.get("compositElement").add(serviceClient.getGui());
	}


}
