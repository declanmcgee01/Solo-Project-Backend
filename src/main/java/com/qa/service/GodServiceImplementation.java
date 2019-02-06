package com.qa.service;

import javax.inject.Inject;

import com.qa.persistence.domain.God;
import com.qa.persistence.repository.GodRepository;
import com.qa.util.JSONUtil;

//Class to implement the GodService interface
public class GodServiceImplementation implements GodService {
	
	char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
	
	//Create instance of repository
	@Inject
	private GodRepository repo;
	
	@Inject JSONUtil util;
	
	public String getAllGods() {
		return repo.getAllGods();
	}
	
	public String createGod(String god) {
		God aGod = util.getObjectForJSON(god, God.class);
		
		if(aGod.getName().length() < 4 || aGod.getName().length() > 10)
		{
			return "{\"message\": \"Name must be between 4 and 10 letters long\"}";
		}else {
			return repo.createGod(god);
		}
	}

	public String deleteGod(Long godID) {
		for(int i = 0; i < alphabet.length; i++) {
			if(godID != alphabet[i]) {
				return repo.deleteGod(godID);
			}							
		}
		return "{\"message\": \"Please enter the ID to Delete\"}";
	}

	public String updateGod(Long godID, String god) {
		return repo.updateGod(godID, god);
	}
	
	public void setRepo(GodRepository repo) {
		this.repo = repo;
	}

	public String findGod(String name) {
		return repo.findGod(name);
	}

}
