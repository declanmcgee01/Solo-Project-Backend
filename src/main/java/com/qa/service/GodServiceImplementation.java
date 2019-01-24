package com.qa.service;

import javax.inject.Inject;

import com.qa.persistence.domain.God;
import com.qa.persistence.repository.GodRepository;
import com.qa.util.JSONUtil;

//Class to implement the GodService interface
public class GodServiceImplementation implements GodService {
	
	//Create instance of repository
	@Inject
	private GodRepository repo;
	//Using JSON
	@Inject
	private JSONUtil util;
	
	public String getAllGods() {
		return repo.getAllGods();
	}
	
	public String createGod(String god) {
		return repo.createGod(god);
	}

	public String deleteGod(Long godID) {
		return repo.deleteGod(godID);
	}

	public String updateGod(Long godID, String god) {
		return repo.updateGod(godID, god);
	}
	
	public void setRepo(GodRepository repo) {
		this.repo = repo;
	}

}
