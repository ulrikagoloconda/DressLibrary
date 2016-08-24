package com.dresslibrary.client.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class DressImages implements Serializable{

	private Map<Integer, String> idPathList; 
	private boolean selected;
	
	public DressImages(){
		idPathList = new HashMap<>();
	}

	public Map<Integer, String> getIdPathList() {
		return idPathList;
	}

	public void setIdPathList(Map<Integer, String> idPathList) {
		this.idPathList = idPathList;
	}
	
	public boolean isSelected(){
		return selected; 
	}
	
	public void setSelected(boolean selected){
		this.selected = selected; 
	}
	
	
}
