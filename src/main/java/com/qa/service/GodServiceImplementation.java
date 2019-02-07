package com.qa.service;

import javax.inject.Inject;

import com.qa.persistence.domain.God;
import com.qa.persistence.repository.GodRepository;
import com.qa.util.JSONUtil;

//Class to implement the GodService interface
public class GodServiceImplementation implements GodService {
	
	String[] invalidWords = new String[] {"poop", "butt", "jobby", "naughty"};
	
	//Create instance of repository
	@Inject
	private GodRepository repo;
	
	@Inject JSONUtil util;
	
	public String getAllGods() {
		return repo.getAllGods();
	}
	
	public String createGod(String god) {
		God aGod = util.getObjectForJSON(god, God.class);
		
		if(aGod.getName().length() < 3 || aGod.getName().length() > 10)
		{
			return "{\"message\": \"Name must be between 3 and 10 letters long\"}";
		}else {
			return repo.createGod(god);
		}
	}

	public String deleteGod(Long godID) {
			if(godID < 1) {
				return "{\"message\": \"Please enter an ID greater than 0\"}";
			}else {
					
				return repo.deleteGod(godID);
			}
	}

	public String updateGod(Long godID, String god) {
		God aGod = util.getObjectForJSON(god,  God.class);
		
		for(int i = 0; i < invalidWords.length; i++) {
			if(aGod.getName().equals(invalidWords[i])) {
				return "{\"message\": \"Please keep names safe for work\"}";
			}
		}
		return repo.updateGod(godID, god);
	}
	
	public String findGod(String name) {
			return repo.findGod(name);
		}

	public void setRepo(GodRepository repo) {
		this.repo = repo;
	}
}
