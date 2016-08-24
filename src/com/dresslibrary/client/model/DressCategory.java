package com.dresslibrary.client.model;

import java.io.Serializable;
import java.util.ArrayList;

public class DressCategory implements Serializable{
	private  ArrayList<String> categoryList; 
	
	public DressCategory(){
		categoryList = new ArrayList<>();
		setCategoryList();
	}
	

	public void setCategoryList(){
		FakeDatabase.initDresses();
		categoryList = FakeDatabase.getAllCategories();
	}
	
	public ArrayList<String> getDressCategoryList(){
		return categoryList; 
	}
}
