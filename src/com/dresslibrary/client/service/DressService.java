package com.dresslibrary.client.service;

import java.util.ArrayList;

import com.dresslibrary.client.model.DressCategory;
import com.dresslibrary.client.model.DressImages;
import com.dresslibrary.client.model.DressInfo;
import com.dresslibrary.client.model.LibraryUser;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("dresservice")
public interface DressService extends RemoteService {
 int calcualte(int num1, int num2);
 DressInfo getDressInfo(int imageID);
 DressImages getDressImages();
DressCategory getAllCategories();
DressImages getSelectedDressImages(String s);
LibraryUser logIn(String userName, String password);
LibraryUser createNewUser(LibraryUser lu, String text);

}
