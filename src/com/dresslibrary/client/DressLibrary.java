package com.dresslibrary.client;

import java.util.ArrayList;

import com.dresslibrary.client.service.DressServiceClientImpl;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class DressLibrary implements EntryPoint {
private DressServiceClientImpl serviceClient; 

	public void onModuleLoad() {
		serviceClient = new DressServiceClientImpl(GWT.getModuleBaseURL()+ "dresservice");
		RootPanel.get("compositElement").add(serviceClient.getGui());
		
	}


}
