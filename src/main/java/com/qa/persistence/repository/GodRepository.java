package com.qa.persistence.repository;

import com.qa.persistence.domain.God;

public interface GodRepository {
	
	String getAllGods();
	String createGod(String god);
	String deleteGod(Long godID);
	String updateGod(Long godID, String god);
	String findGod(String name);

}
