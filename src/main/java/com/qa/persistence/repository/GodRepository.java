package com.qa.persistence.repository;

public interface GodRepository {
	
	String getAllGods();
	String createGod(String god);
	String deleteGod(Long godID);
	String updateGod(Long godID, String god);
	String findGod(String name);

}
