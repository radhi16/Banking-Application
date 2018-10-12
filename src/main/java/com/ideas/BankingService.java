package com.ideas;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ideas.db.ConnectionManager;
import com.ideas.db.DbManager;

public class BankingService {
	public Integer getCount() {
	   DbManager dbManager = new DbManager();
		ResultSet resultset = dbManager.find("select count(*) as count from account");
		Integer count = 0;
		try {
			while (resultset.next()) {
					count = resultset.getInt("count");
				}
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			dbManager.closeConnection();
		}
		return count;
}

	public void saveAccount(Account account) {
		DbManager dbManager = new DbManager();
		dbManager.save("INSERT INTO account(accname, Address, DOB, PAN_NO, Mobile_No, Account_type) VALUES ('" +
					 account.getName() + "','" + account.getAddress() + "','" + account.getDate() + "','" + account.getPanNo() + "','" + account.getMobNo()+ "','"  + account.getAccountType()+ "');");
		dbManager.closeConnection();
		
		}

	public List<Account> getAll() {
		DbManager dbManager = new DbManager();
		List<Account> volist = new ArrayList<Account>();
		ResultSet resultset = dbManager.find("SELECT * FROM account;");
		try {
			while (resultset.next()) {
					volist.add(new Account(resultset.getInt("ID"),resultset.getString("accname"),resultset.getString("address"),resultset.getString("DOB"),resultset.getString("PAN_NO"),resultset.getString("Mobile_No"),resultset.getString("Account_type")));
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			dbManager.closeConnection();
		}
		return volist;
	}
		
	public List<Account> getAccountByPan(String pan) {
		DbManager dbManager = new DbManager();
		List<Account> volist = new ArrayList<Account>();
		ResultSet resultset = dbManager.find("SELECT * FROM account WHERE PAN_NO = " + pan + ";");
		try {
			while (resultset.next()) {
					volist.add(new Account(0,resultset.getString("accname"),resultset.getString("Address"),resultset.getString("DOB"),resultset.getString("PAN_NO"),resultset.getString("Mobile_No"),resultset.getString("Account_type")));
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			dbManager.closeConnection();
		}
		return volist;
	}
	
	
	public List<Account> deleteAccountById(String id) {
		DbManager dbManager = new DbManager();
		List<Account> volist = new ArrayList<Account>();
		dbManager.save("DELETE FROM account WHERE ID = " + id + ";");
		ResultSet resultset = dbManager.find("SELECT * FROM account;");
		try {
			while (resultset.next()) {
					volist.add(new Account(0,resultset.getString("accname"),resultset.getString("address"),resultset.getString("DOB"),resultset.getString("PAN_NO"),resultset.getString("Mobile_No"),resultset.getString("Account_type")));
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			dbManager.closeConnection();
		}
		return volist;
	}
	
	public List<Account> getAccountById(int id) {
		DbManager dbManager = new DbManager();
		List<Account> volist = new ArrayList<Account>();
		ResultSet resultset = dbManager.find("SELECT * FROM account WHERE ID = " + id + ";");
		try {
			while (resultset.next()) {
					volist.add(new Account(resultset.getInt("ID"),resultset.getString("accname"),resultset.getString("Address"),resultset.getString("DOB"),resultset.getString("PAN_NO"),resultset.getString("Mobile_No"),resultset.getString("Account_type")));
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			dbManager.closeConnection();
		}
		return volist;
	}

	public void updateWhenIdGiven(int id, Account account) {
		DbManager dbManager = new DbManager();
		dbManager.save("UPDATE account SET accname='" + account.getName() + "',Address='" +account.getAddress()+ "',DOB='"
				+ account.getDate()+ "',PAN_NO='" +account.getPanNo() + "',Mobile_No='"+ account.getMobNo()+
				"',Account_type='"+ account.getAccountType() + "'WHERE ID=" + id);
	dbManager.closeConnection();

	}
	
	
	}
	
			

