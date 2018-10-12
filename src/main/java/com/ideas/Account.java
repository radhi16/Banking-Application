package com.ideas;

import java.sql.Date;

public class Account
{
 
	private int id;
	private String name;
	private String address;
	private String date;
	private String panNo;
	private String mobNo;
	private String accountType;
	
	public Account(int id, String name, String addres, String date, String panNo, String mobNo,	String accountType) {
				this.id = id;
				this.name = name;
				this.address = addres;
				this.date = date;
				this.panNo = panNo;
				this.mobNo = mobNo;
				this.accountType = accountType;
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	
	public String getAddress() {
		return address;
	}
	

	public String getDate() {
		return date;
	}


	public String getAccountType() {
		return accountType;
	}


	public String getPanNo() {
		return panNo;
	}


	public String getMobNo() {
		return mobNo;
	}








}
