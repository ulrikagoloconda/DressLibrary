package com.dresslibrary.client;

import java.util.ArrayList;

import com.dresslibrary.client.service.DressServiceClientImpl;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FileUpload;
import com.google.gwt.user.client.ui.FormPanel;
import com.google.gwt.user.client.ui.FormPanel.SubmitCompleteEvent;
import com.google.gwt.user.client.ui.FormPanel.SubmitCompleteHandler;
import com.google.gwt.user.client.ui.FormPanel.SubmitEvent;
import com.google.gwt.user.client.ui.FormPanel.SubmitHandler;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
//import org.moxieapps.gwt.uploader.client.Uploader;  
//import org.moxieapps.gwt.uploader.client.events.*;

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

	public static void viewAddDressGui() {
		RootPanel.get("compositElement").clear();
		RootPanel.get("compositElement").add(serviceClient.getAddDressGui());
	}

}


