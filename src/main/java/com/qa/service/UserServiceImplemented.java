package com.qa.service;

import javax.inject.Inject;

import com.qa.persistence.repository.UserRepository;
import com.qa.util.JSONUtil;

public class UserServiceImplemented {
	
	@Inject
	private UserRepository repo;
	
	@Inject
	private JSONUtil util;
	
	public String getAllUsers() {
		return repo.getAllUsers();
	}
	
	public String createUsers(String user) {
		return repo.createUser(user);
	}
	
	public String deleteUser(Long userID) {
		return repo.deleteUser(userID);
	}

}
