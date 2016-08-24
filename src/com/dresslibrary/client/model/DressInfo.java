package com.dresslibrary.client.model;

import java.io.Serializable;
import java.util.ArrayList;

import com.google.gwt.user.client.Window;

public class DressInfo implements Serializable{

	

	private String category;
	private int size;
	private String Location; 
	private String state; 
	private ArrayList<String> comments;
	private int imageID;
	private boolean isAvailable;
	
	public DressInfo(){
		
	}
	
	public DressInfo(String category, int size, String location, String state, ArrayList<String> comments, int imageID, boolean isAvailable){
		this.category = category;
		this.size = size; 
		this.state = state; 
		this.Location = location; 
		this.comments = comments; 
		this.imageID = imageID; 
		this.isAvailable = isAvailable; 		
	}
	
	
	public int getImageID() {
		return imageID;
	}
	public void setImageID(int imageID) {
		this.imageID = imageID;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public String getLocation() {
		return Location;
	}
	public void setLocation(String location) {
		Location = location;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public ArrayList<String> getComments() {
		return comments;
	}
	public void setComments(ArrayList<String> comments) {
		this.comments = comments;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	} 
	
	
	
}
