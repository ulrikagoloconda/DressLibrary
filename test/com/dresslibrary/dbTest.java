package com.dresslibrary;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;

import com.dresslibrary.client.model.LibraryUser;
import com.dresslibrary.client.service.DressServiceClientImpl;

import MySQLDatabase.DBConnection;

public class dbTest {
	DBConnection db;
	@Test
	public void login() {
		 db = new DBConnection();
		try {
			db.connectToDB();
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	LibraryUser lu = db.loginQ("Goloconda", "Goloconda");
	
	assertEquals(null, lu.getfName());
	}
	
	@Test
	public void createNewUser(){
		LibraryUser lu = new LibraryUser();
		lu.setEmail("flagrans@hotmail.com");
		lu.setfName("Goloconda");
		lu.setlName("Fahlén");
		lu.setUserNamne("adminUser");
		lu.setNumberOfDelays(0);
		lu.setRate(5);
		lu.setKarma(10);
		try {
			db.connectToDB();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Körs detta ");
		LibraryUser returned = db.createNewUser(lu, "goloconda");
		
		boolean asserted = false; 
		if(returned.getUserID() < 0){
			asserted = true; 
		}
		
		assertEquals(asserted, true);
	}

}
