package com.dresslibrary.client.model;

import java.io.Serializable;
import java.util.Random;

public class LibraryUser implements Serializable{
	
	 private int userID; 
	 private String userNamne;
	 private String email;
	 private String  fName;
	 private String lName;
	 private int rate;
	 private int karma;
	 private int numberOfDelays;
	
	public LibraryUser(){
		
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getUserNamne() {
		return userNamne;
	}

	public void setUserNamne(String userNamne) {
		this.userNamne = userNamne;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	public int getKarma() {
		return karma;
	}

	public void setKarma(int karma) {
		this.karma = karma;
	}

	public int getNumberOfDelays() {
		return numberOfDelays;
	}

	public void setNumberOfDelays(int numberOfDelays) {
		this.numberOfDelays = numberOfDelays;
	}

	
}