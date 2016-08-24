package com.dresslibrary.client.model;

import java.io.Serializable;
import java.util.Random;

public class LibraryUser implements Serializable{
	
	private String name; 
	private int rate; 
	
	public LibraryUser(){
		
	}

	public LibraryUser(String name){
		Random rand = new Random();
		rate = rand.nextInt(5);
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}
}
