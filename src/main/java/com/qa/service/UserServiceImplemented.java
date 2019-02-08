package com.qa.service;

import javax.inject.Inject;

import com.qa.persistence.repository.UserRepository;

public class UserServiceImplemented implements UserService {
	
	@Inject
	private UserRepository repo;
	
	public String getAllUsers() {
		return repo.getAllUsers();
	}
	
	public String createUser(String user) {
		return repo.createUser(user);
	}
	
	public String deleteUser(Long userID) {
		return repo.deleteUser(userID);
	}

}
