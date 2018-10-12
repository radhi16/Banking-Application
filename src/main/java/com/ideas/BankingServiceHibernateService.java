package com.ideas;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ideas.db.DbManager;
import com.ideas.entity.Account;

public class BankingServiceHibernateService {

	public List getAllAccounts() {
		EntityManager entityManager = getEntityManager();

		return entityManager.createNativeQuery("select * from account").getResultList();

	}

	private EntityManager getEntityManager() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JPAExample");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		return entityManager;
	}

	public Account createNewAccount() {
		Account account = new Account();
		account.setName("junit");
		account.setAddress("ideas");
		account.setDate("2000-10-10");
		account.setPanNo("13");
		account.setMobNo("123");
		account.setAccountType("savings");

		EntityManager entityManager = getEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(account);
		entityManager.getTransaction().commit();

		return account;
	}

	public Account updateAccount(int accountid) {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("JPAExample");
		EntityManager entityManager = getEntityManager();
		entityManager.getTransaction().begin();
		Account account = entityManager.find(Account.class, accountid);
		account.setName(account.getName() + " Updated in unit test");
		entityManager.getTransaction().commit();
		entityManager.close();
		emfactory.close();
		return account;

	}

	public void deleteAccount() {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("JPAExample");
		EntityManager entityManager = getEntityManager();
		entityManager.getTransaction().begin();
		;
		Account account = entityManager.find(Account.class, 6);
		entityManager.remove(account);
		entityManager.getTransaction().commit();
		entityManager.close();
		emfactory.close();

	}

	public List findByNamedQuery(String byName) {
		//EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("JPAExample");
		EntityManager entityManager = getEntityManager();
		entityManager.getTransaction().begin();
		Query createNamedQuery = entityManager.createNamedQuery(byName);
		createNamedQuery.setParameter("paramName", "junit");
		List resultList = createNamedQuery.getResultList();
		entityManager.getTransaction().commit();
		entityManager.close();
		//emfactory.close();
		return resultList;
	}

}
