package com.tatharo.onelegacy.hibernate.domain.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
/**
 * 
 * Primary Entity containing all data for loging in and email for resetting passwords, has access to account triggers,linked WoWCharacters and Person details if this is made available.
 *
 */
@Entity
public final class UserAccount {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "USER_ID", unique = true, nullable = false)
	private long userId;

	@Column(unique = true)
	private String userName;
	private String password;
	@Column(unique = true)
	private String email;
	@OneToMany(targetEntity=WoWCharacter.class,mappedBy="userAccount",fetch = FetchType.EAGER)
	private List<WoWCharacter> characters;
	@OneToOne(cascade = CascadeType.ALL)
	private Person person;
	@OneToOne
	private AccountTriggers accountTriggers;

	public UserAccount() {
	}

	public UserAccount(String userName, String password, String email) {
		this.userName = userName;
		this.password = password;
		this.email = email;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
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


	public List<WoWCharacter> getCharacters() {
		return characters;
	}

	public void setCharacters(List<WoWCharacter> characters) {
		this.characters = characters;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getUserId() {
		return userId;
	}

	public AccountTriggers getAccountTriggers() {
		return accountTriggers;
	}

	public void setAccountTriggers(AccountTriggers accountTriggers) {
		this.accountTriggers = accountTriggers;
	}
	
}
