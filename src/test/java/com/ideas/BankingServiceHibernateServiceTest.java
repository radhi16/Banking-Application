package com.ideas;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.ideas.entity.Account;

public class BankingServiceHibernateServiceTest {

	
	
	@Test
	public void shouldGetAllAccount(){
	  BankingServiceHibernateService service = new BankingServiceHibernateService();
	  List listOfAccounts = service.getAllAccounts();
	 assertTrue(listOfAccounts!=null);
	}
	
	@Test
	public void shouldCreateNewAccount(){
	  BankingServiceHibernateService service = new BankingServiceHibernateService();
	  Account account = service.createNewAccount();
	  
	  assertTrue(account!=null);
	}
	  
	@Test
	public void shouldUpdateAccount(){
		BankingServiceHibernateService service = new BankingServiceHibernateService();
		Account account = service.createNewAccount();
		account = service.updateAccount(account.getId());
		assertTrue(account.getName().equalsIgnoreCase("junit Updated in unit test"));
				
	}
	
	  @Test
	  public void shouldDeleteAccount(){
		  BankingServiceHibernateService service = new BankingServiceHibernateService();
		  List preListOfAccounts = service.getAllAccounts();
		  int precount = preListOfAccounts.size();	
		  service.deleteAccount();
		  List postListOfAccounts = service.getAllAccounts();
		  int postcount = postListOfAccounts.size();
		  Assert.assertEquals(precount, postcount+1);
	  }
	  
	  @Test
	  public void shouldFindByNamedQuery(){
		  BankingServiceHibernateService service = new BankingServiceHibernateService();
		  List list = service.findByNamedQuery("FIND_BY_NAME");
		  assertNotNull(list);
	}
}
	
