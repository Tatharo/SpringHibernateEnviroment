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
	@Column(name = "ID", unique = true)
	private long userId;
//	@OneToMany(fetch = FetchType.EAGER, mappedBy = "Character")
//	private List<Character> characters;
	@Column(unique = true)
	private String userName;
	// TODO Password Encryption
	private String password;
	@Column(unique = true)
	private String email;

	public UserAccount() {
	}

	public UserAccount(String userName, String password, String email) {
		this.userName = userName;
		this.password = password;
		this.email = email;
	}

	public String getUserName() {
		return userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}


//	public List<Character> getCharacters() {
//		return characters;
//	}
//
//	public void setCharacters(List<Character> characters) {
//		this.characters = characters;
//	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

}
