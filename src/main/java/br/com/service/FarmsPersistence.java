package br.com.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FarmsPersistence {

	private static FarmsPersistence persistence;
	
	private EntityManagerFactory factory;

	private FarmsPersistence(){
		this.factory = Persistence.createEntityManagerFactory("farms");
	}
	
	public static FarmsPersistence instance(){
		if(persistence == null){
			persistence = new FarmsPersistence();
		}
		return persistence;
	}
	
	public EntityManager createEntityManager(){
		EntityManager manager = factory.createEntityManager();
		return manager;
	}
}
