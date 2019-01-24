package com.qa.service;

//Interface for methods to interact with DB
public interface GodService {
	
	//Display all gods
	String getAllGods();
	
	//Create god
	String createGod(String god);
	
	//Delete God
	String deleteGod(Long godID);
	
	//updateGod
	String updateGod(Long godID, String god);

}