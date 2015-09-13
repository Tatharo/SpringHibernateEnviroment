package com.tatharo.onelegacy.hibernate.domain.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public final class UserAccount {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID", unique=true)
	private long id;
//	private Person person;
    @Column(unique=true)
	private String userName;
	//TODO Password Encryption
	private String password;
    @Column(unique=true)
	private String email;
    
	public UserAccount() {
		super();
	}

	public UserAccount(String userName, String password, String email) {
		this.userName = userName;
		this.password = password;
		this.email = email;
	}

//	public Person getPerson() {
//		return person;
//	}
	public String getUserName() {
		return userName;
	}
	public String getPassword() {
		return password;
	}
	public String getEmail() {
		return email;
	}
	
}
