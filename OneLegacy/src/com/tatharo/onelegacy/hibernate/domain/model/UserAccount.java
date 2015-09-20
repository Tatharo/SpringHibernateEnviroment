package com.tatharo.onelegacy.hibernate.domain.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "UserAccount", uniqueConstraints = { @UniqueConstraint(columnNames = "ID") })
public final class UserAccount {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	private long userId;

	@Column(unique = true)
	private String userName;
	// TODO Password Encryption
	private String password;
	@Column(unique = true)
	private String email;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "CHARACTER_ID")
	private List<WoWCharacter> characters;

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

	// public List<Character> getCharacters() {
	// return characters;
	// }
	//
	// public void setCharacters(List<Character> characters) {
	// this.characters = characters;
	// }

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
