package br.com.service;

import javax.persistence.EntityManager;

import br.com.model.Researcher;

public class LoginService {
	
	public void insert(Researcher research){
		EntityManager manager = FarmsPersistence.instance().createEntityManager();
		manager.getTransaction().begin();
		manager.persist(research);
		manager.getTransaction().commit();
		manager.close();
	}
}
