package com.qa.persistence.repository;

import static javax.transaction.Transactional.TxType.SUPPORTS;
import static javax.transaction.Transactional.TxType.REQUIRED;

import java.util.Collection;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import com.qa.persistence.domain.User;
import com.qa.util.JSONUtil;

@Transactional(SUPPORTS)
@Default
public class UserRepositoryImplementation implements UserRepository{
	
	@PersistenceContext(unitName = "primary")
	private EntityManager manager;
	
	@Inject JSONUtil util;
	
	public String getAllUsers() {
		Query query = manager.createQuery("Select u FROM User u");
		Collection<User> users = (Collection<User>) query.getResultList();
		return util.getJSONForObject(users);
	}
	
	@Transactional(REQUIRED)
	public String createUser(String user) {
		User aUser = util.getObjectForJSON(user, User.class);
		manager.persist(aUser);
		return "{\"Message\": \"A user has been sucessfully added\"}";
	}
	
	@Transactional(REQUIRED)
	public String deleteUser(Long userID) {
		User userInDB = getUser(userID);
		if(userInDB != null) {
			manager.remove(userInDB);
		}
		return "{\"Message\": \"User has been deleted\"}";
	}
	
	public User getUser(Long userID) {
		return manager.find(User.class, userID);
	}
	
	public void setUtil(JSONUtil util) {
		this.util = util;
	}

}
