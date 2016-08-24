package com.dresslibrary.client.model;

import java.util.ArrayList;
import java.util.Map;

public class FakeDatabase {
	
	private static ArrayList<LibraryUser> users;
	
	private static ArrayList<DressInfo> infoList;
	
	private static Map<Integer,String> dressImages;
	
	private static ArrayList<String> allCategories; 
	
	
	
	public static ArrayList<LibraryUser> getUsers() {
		return users;
	}



	public static void setUsers(ArrayList<LibraryUser> users) {
		FakeDatabase.users = users;
	}



	public static ArrayList<DressInfo> getInfoList() {
		return infoList;
	}



	public static void setInfoList(ArrayList<DressInfo> infoList) {
		FakeDatabase.infoList = infoList;
	}



	public static Map<Integer,String> getDressImages() {
		return dressImages;
	}



	public static void setDressImages(Map<Integer,String> dressImages) {
		FakeDatabase.dressImages = dressImages;
	}
	
	
	
	public static ArrayList<String> getAllCategories() {
		return allCategories;
	}



	public static void setAllCategories(ArrayList<String> allCategories) {
		FakeDatabase.allCategories = allCategories;
	}


	

	public static void initDresses(){
		infoList = new ArrayList<>();
		ArrayList<String> comments = new ArrayList<>();
		comments.add("Trevligt plagg, passar bra till fester. Fin passform");
		DressInfo dr1 = new DressInfo("Byxa", 40, "Boden", "OK", comments, 1,true);
		comments = new ArrayList<>();
		comments.add("Fint material, passar fint till bättre tillställningar");
		DressInfo dr2 = new DressInfo("Byxa", 38, "Stockholm", "Mycket bra skicka", comments, 2, true);
		comments = new ArrayList<>();
		comments.add("Rolig och charmig klänning i 50-talsstil. Mycket uppskattad i raggarsammanhang och bilträffar. Oljefläckarna går nog bort i tvätten. ");
		DressInfo dr3 = new DressInfo("Klänning", 36, "Arvika", "Bra skick", comments, 3, true);
		comments = new ArrayList<>();
		comments.add("Fin klänning med bra passform!");
		comments.add("Klänningen är utmärkt på fester där man vill känna sig elegant utan att ta över tillställningen");
		DressInfo dr4 = new DressInfo("Klänning", 42, "Göteborg", "Bra skick", comments, 4, false);
		comments = new ArrayList<>();
		comments.add("Stickad tröja som funkar i alla lägen, arbetsintervjun, middag med svärmor.");
		DressInfo dr5 = new DressInfo("Tröja", 44, "Norrköping", "OK", comments, 5, false);
		comments = new ArrayList<>();
		comments.add("Stickad tröja, fint möster som passar till det mesta");
		DressInfo dr6 = new DressInfo("Tröja", 40, "Stockholm", "Bra skick", comments, 6, true);
		comments = new ArrayList<>();
		
		DressInfo dr7 = new DressInfo("Byxa", 32, "Umeå", "Bra skick", comments, 7, true);
		DressInfo dr8 = new DressInfo("Byxa", 40, "Åmål", "Dåligt sick", comments, 8, true);
		DressInfo dr9 = new DressInfo("Klänning", 42, "Stockholm", "Bra sick", comments, 9, true);
		DressInfo dr10 = new DressInfo("Klänning", 38, "Stockholm", "Mycket bra sick", comments, 10, true);
		DressInfo dr11 = new DressInfo("Tröja", 38, "Stockholm", "Bra sick", comments, 11, true);
		DressInfo dr12 = new DressInfo("Tröja", 40, "Göteborg", "Bra sick", comments, 12, true);
		DressInfo dr13 = new DressInfo("Tröja", 42, "Göteborg", "Ok sick", comments, 13, true);
		DressInfo dr14 = new DressInfo("Tröja", 48, "Malmö", "Bra sick", comments, 14, true);



		
		
		infoList.add(dr1);
		infoList.add(dr2);
		infoList.add(dr3);
		infoList.add(dr4);
		infoList.add(dr5);
		infoList.add(dr6);
		infoList.add(dr7);
		infoList.add(dr8);
		infoList.add(dr9);
		infoList.add(dr10);
		infoList.add(dr11);
		infoList.add(dr12);
		infoList.add(dr13);
		infoList.add(dr14);

		
		allCategories = new ArrayList<>();
		
		allCategories.add(dr1.getCategory());
		allCategories.add(dr2.getCategory());
		allCategories.add(dr3.getCategory());
		allCategories.add(dr4.getCategory());
		allCategories.add(dr5.getCategory());
		allCategories.add(dr6.getCategory());

		
	}


	public static void initUsers(){
		users = new ArrayList<>();
	}

}
