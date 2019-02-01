package com.qa.persistence.repository;

public interface UserRepository {
	
	String getAllUsers();
	String createUser(String user);
	String deleteUser(Long userID);

}
