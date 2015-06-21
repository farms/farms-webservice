package br.com.service;
import static org.junit.Assert.*;

import org.junit.Test;

import br.com.core.OperationException;
import br.com.model.Researcher;
import br.com.service.LoginService;
import br.com.webservice.LoginResource;


public class LoginTest{
	
	private LoginService loginService = new LoginService();
	private final String nameTest = "Fulano A";
	private final String emailTest = "fulano@email.com";
	private final String passwordTest = "12345";
	
	
	@Test 
	public void addResearcherSuccessTest(){
		Researcher researcher = new Researcher();
		researcher.setName(nameTest);
		researcher.setEmail(emailTest);
		researcher.setPassword(passwordTest);
		try {
			this.loginService.insert(researcher);
			assertTrue(true);
		} catch (OperationException e) {
			assertFalse(true);
		}
	}
	
	@Test 
	public void loginSuccessTest(){
		Researcher researcher = new Researcher();
		researcher.setName(nameTest);
		researcher.setEmail(emailTest);
		researcher.setPassword(passwordTest);
		try {
			this.loginService.login(researcher);
			assertTrue(true);
		} catch (OperationException e) {
			assertFalse(true);
		}
	}
	
	@Test 
	public void loginFailWithWrongEmailTest(){
		Researcher researcher = new Researcher();
		researcher.setName(nameTest);
		researcher.setEmail(emailTest+"a");
		researcher.setPassword(passwordTest);
		try {
			this.loginService.login(researcher);
			assertFalse(true);
		} catch (OperationException e) {
			assertTrue(e.getCode() == LoginResource.ACCOUNT_NOT_EXISTS);
		}
	}
	
	@Test 
	public void loginFailWithWrongPasswordTest(){
		Researcher researcher = new Researcher();
		researcher.setName(nameTest);
		researcher.setEmail(emailTest);
		researcher.setPassword(passwordTest+"1");
		try {
			this.loginService.login(researcher);
			assertFalse(true);
		} catch (OperationException e) {
			assertTrue(e.getCode() == LoginResource.PASSWORD_NOT_MATCHES);
		}
	}

}
