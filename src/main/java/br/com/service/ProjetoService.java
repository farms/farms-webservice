package br.com.service;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.model.Projeto;

public class ProjetoService {

	public void inserir(Projeto projeto){
		EntityManager manager = FarmsPersistence.instance().createEntityManager();
		manager.getTransaction().begin();
		manager.persist(projeto);
		manager.getTransaction().commit();
		manager.close();
	}
	
	@SuppressWarnings("unchecked")
	public List<Projeto> getAll(){
		EntityManager manager = FarmsPersistence.instance().createEntityManager();
		return manager
				  .createQuery("select p from Projeto as p")
				  .getResultList();
	}
	
}
