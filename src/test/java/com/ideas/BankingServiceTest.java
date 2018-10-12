package com.ideas;

import java.sql.Date;
import java.util.List;

import org.junit.Test;

import junit.framework.Assert;

public class BankingServiceTest {

	@Test
	public void shouldInsertData()
	{
		BankingService bankingService = new BankingService();
		Integer preCount  = bankingService.getCount();
		//AccountVO account = new AccountVO("PQR", "Pune", "1999/02/02", "102", "8149374580", "savings" );
		//bankingService.saveAccount(account);
		Integer postCount = bankingService.getCount() ;
		Assert.assertEquals(preCount+1, postCount, 0);
	}
	
	@Test
	public void shouldReturnCountOfAccounts()
	{
		BankingService bankingService = new BankingService();
		Assert.assertNotNull(bankingService.getCount());
		//Assert.assertEquals(12, bankingService.getCount(), 0);
	}
	
	@Test
	public void shouldGetAll()
	{
		BankingService bankingService = new BankingService();
		List<Account> list = bankingService.getAll();
		Integer size = list.size();
		Integer count= bankingService.getCount();
		Assert.assertEquals(count, size);
	}
	
	@Test
	public void shouldGetAccountByPanCard()
	{
		BankingService bankingService = new BankingService();
		List<Account> list = bankingService.getAccountByPan("100");
		String pan= list.get(0).getPanNo() ;
		Assert.assertEquals("100", pan);
	}
	
	@Test
	public void shouldDeleteAccountByPanCard()
	{
		BankingService bankingService = new BankingService();
		List<Account> list = bankingService.deleteAccountById("2");
		List<Account> list1 = bankingService.getAll();
		Integer size = list1.size();
		Integer count= bankingService.getCount();
		Assert.assertEquals(count, size);
	}
}
	

