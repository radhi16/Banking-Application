package com.ideas.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="account")
/*@NamedQueries({@NamedQuery(name="FIND_BY_NAME", query="select a from Account a where a.name=:paramName")})*/
@NamedQueries({@NamedQuery(name="FIND_BY_NAME",query="select a from Account a where a.name=:paramName")})
public class Account {
	private int id;
	private String name;
	private String address;
	private String date;
	private String panNo;
	private String mobNo;
	private String accountType;
	
	
	@Id
	@Column(name="ID") 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	@Column(name="accname") 
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name="Address") 
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	@Column(name="DOB") 
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	
	@Column(name="PAN_NO") 

	public String getPanNo() {
		return panNo;
	}
	public void setPanNo(String panNo) {
		this.panNo = panNo;
	}
	
	
	@Column(name="Mobile_No") 
	public String getMobNo() {
		return mobNo;
	}
	public void setMobNo(String mobNo) {
		this.mobNo = mobNo;
	}
	
	@Column(name="Account_type") 
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
		
}
