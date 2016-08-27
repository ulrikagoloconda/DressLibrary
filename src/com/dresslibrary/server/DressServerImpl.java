package com.dresslibrary.server;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.dresslibrary.client.model.DressCategory;
import com.dresslibrary.client.model.DressImages;
import com.dresslibrary.client.model.DressInfo;
import com.dresslibrary.client.model.FakeDatabase;
import com.dresslibrary.client.model.LibraryUser;
import com.dresslibrary.client.service.DressService;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import MySQLDatabase.DBConnection;

public class DressServerImpl extends RemoteServiceServlet implements DressService{

	DBConnection con = new DBConnection();

	Map<Integer, String> idPathMap;


	@Override
	public DressInfo getDressInfo(int imageID) {
		System.out.println("I GetDressInfo");
		DressInfo di  = new DressInfo(); 
		if(FakeDatabase.getInfoList() == null){
			FakeDatabase.initDresses();
			System.out.println("I GetDressInfo if null");


		}
		for(DressInfo info : FakeDatabase.getInfoList()){
			System.out.println("I info " + info.getCategory() + " " + info.getImageID());

			if(info.getImageID() == imageID){
				di = info;
				System.out.println("I info if-satsen" + info.getCategory());

			}
		}

		return di; 
	}

	@Override
	public DressImages getDressImages() { 
		DressImages imagesObject = new DressImages();

		initMap();

		imagesObject.setIdPathList(idPathMap);
		FakeDatabase.setDressImages(idPathMap);
		return imagesObject;

	}

	public void initMap(){
		idPathMap = new HashMap<>();
		idPathMap.put(1, "images/byxa1.jpg");
		idPathMap.put(2,"images/byxa2.jpg");
		idPathMap.put(3,"images/klänning1.jpg");
		idPathMap.put(4,"images/klänning2.jpg");
		idPathMap.put(5,"images/tröja1.jpg");
		idPathMap.put(6,"images/tröja2.jpg");
		idPathMap.put(7,"images/byxa3.jpg" );
		idPathMap.put(8,"images/byxa4.jpg" );
		idPathMap.put(9,"images/klänning3.jpg" );
		idPathMap.put(10,"images/klänning4.jpg" );
		idPathMap.put(11,"images/tröja3.jpg");
		idPathMap.put(12,"images/tröja4.jpg");
		idPathMap.put(13,"images/tröja5.jpg");
		idPathMap.put(14,"images/tröja6.jpg");
	}


	@Override
	public DressCategory getAllCategories() {
		return new DressCategory();
	}

	@Override
	public DressImages getSelectedDressImages(String s) {
		Map<Integer, String> localMap = new HashMap<>();
		DressImages returnImages = new DressImages();
		FakeDatabase.initDresses();
		initMap();
		for(DressInfo di : FakeDatabase.getInfoList()){

			if(di.getCategory().equals(s)){
				int id = di.getImageID();
				String path = idPathMap.get(id);
				localMap.put(id, path);
			}
		}

		returnImages.setIdPathList(localMap);
		return returnImages; 
	}

	@Override
	public LibraryUser logIn(String userName, String password) {
		LibraryUser lu = null; 
		try {
			con.connectToDB();
			lu =  con.loginQ(userName,password);
			System.out.println("login userid" + lu.getUserID());
			
			return lu;
		} catch (Exception e) {
			e.printStackTrace();

		}
		return lu; 
	}

	@Override
	public int calcualte(int num1, int num2) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public LibraryUser createNewUser(LibraryUser lu, String password) {
		try {
			con.connectToDB();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con.createNewUser(lu, password);
	}
}
