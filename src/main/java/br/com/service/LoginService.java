package br.com.service;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.core.FarmsCrypt;
import br.com.core.OperationException;
import br.com.model.Researcher;
import br.com.webservice.LoginResource;

public class LoginService {
	
	public void insert(Researcher researcher) throws OperationException{
		Researcher reasearcherCreated = this.find(researcher.getEmail());
		if(reasearcherCreated == null){
			EntityManager manager = FarmsPersistence.instance().createEntityManager();
			manager.getTransaction().begin();
			researcher.setPassword(FarmsCrypt.hashPwd(researcher.getPassword()));
			manager.persist(researcher);
			manager.getTransaction().commit();
			manager.close();
		}else{
			throw new OperationException(LoginResource.ACCOUNT_ALREADY_CREATED, "Account already created");
		}
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
	
	public void login(Researcher researcher) throws OperationException{
		Researcher reasearcherOnDatabase = this.find(researcher.getEmail());
		if(reasearcherOnDatabase == null){
			throw new OperationException(LoginResource.ACCOUNT_NOT_EXISTS, "Account not exists");	
		}else{
			if(!FarmsCrypt.checkPwd(researcher.getPassword(), reasearcherOnDatabase.getPassword())){
				throw new OperationException(LoginResource.PASSWORD_NOT_MATCHES, "Password not matches");
			}
		}
	}
}
