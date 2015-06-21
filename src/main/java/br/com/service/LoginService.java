package br.com.service;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.core.FarmsCrypt;
import br.com.model.Researcher;

public class LoginService {
	
	public void insert(Researcher research){
		EntityManager manager = FarmsPersistence.instance().createEntityManager();
		manager.getTransaction().begin();
		research.setPassword(FarmsCrypt.hashPwd(research.getPassword()));
		manager.persist(research);
		manager.getTransaction().commit();
		manager.close();
	}
	
	public Researcher find(String email){
		EntityManager manager = FarmsPersistence.instance().createEntityManager();
		Query query =  manager.createQuery("select r from Researcher r where r.email =:email");
		query.setParameter("email", email);
		List<?> list = query.getResultList();
		if(list.size() == 1){
			return (Researcher)list.get(0);
		}else{
			return null;
		}
	}
}
