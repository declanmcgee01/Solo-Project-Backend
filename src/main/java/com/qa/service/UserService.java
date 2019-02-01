package com.qa.service;

public interface UserService {
	
	String getAllUsers();
	
	String createUser(String user);
	
	String deleteUser(Long userID);

}
