package com.qa.persistence.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;


import com.qa.persistence.domain.God;
import com.qa.util.JSONUtil;


import java.util.Collection;

@Transactional(SUPPORTS)
@Default
public class GodRepositoryImplementation implements GodRepository {

	@PersistenceContext(unitName = "primary")
	private EntityManager manager;
	
	@Inject JSONUtil util;
	
	public String getAllGods() {
		Query query = manager.createQuery("Select g FROM God g");
		Collection<God> gods = (Collection<God>) query.getResultList();
		return util.getJSONForObject(gods);
	}

	@Transactional(REQUIRED)
	public String createGod(String god) {
		God agod = util.getObjectForJSON(god, God.class);
		manager.persist(agod);
		return "{\"Message\": \"A god has been sucessfully added\"}";
	}

	@Transactional(REQUIRED)
	public String deleteGod(Long godID) {
		God godInDB = findGod(godID);
		if(godInDB != null) {
			manager.remove(godInDB);
		}
		return "{\"Message\": \"god has been deleted\"}";
	}

	public String updateGod(Long godID, String god) {
		God godToUpdate = findGod(godID);
		God jsongod = util.getObjectForJSON(god, God.class);
		
		if(godToUpdate !=null) {
			manager.remove(godToUpdate);
			manager.persist(jsongod);
			return "{\"Message\": \"god has been updated\"}";
		}
		return "{\"Message\": \"god did not update\"}";

	}

	public God findGod(Long godID) {
		return manager.find(God.class, godID);
	}
	
	private void setManager(EntityManager manager) {
		this.manager = manager;
	}
	
	public void setUtil(JSONUtil util) {
		this.util = util;
	}

	

}

