package com.qa.service;

public interface GodService {
	
	String getAllGods();
	
	String createGod(String god);
	
	String deleteGod(Long godID);
	
	String updateGod(Long godID, String god);

}