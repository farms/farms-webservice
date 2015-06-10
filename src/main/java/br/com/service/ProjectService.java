package br.com.service;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.model.Project;

public class ProjectService {

	public void insert(Project projeto){
		EntityManager manager = FarmsPersistence.instance().createEntityManager();
		manager.getTransaction().begin();
		manager.persist(projeto);
		manager.getTransaction().commit();
		manager.close();
	}
	
	@SuppressWarnings("unchecked")
	public List<Project> getAll(){
		EntityManager manager = FarmsPersistence.instance().createEntityManager();
		return manager
				  .createQuery("select p from Projeto as p")
				  .getResultList();
	}
	
}
