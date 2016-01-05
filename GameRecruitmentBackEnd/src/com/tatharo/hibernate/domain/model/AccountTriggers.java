package com.tatharo.hibernate.domain.model;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

//TODO Triggers after account creation to be validated
/**
 * 
 * Class dealing with general requirements and should trigger setting these missing requirements on login.
 *
 */
@Entity
public class AccountTriggers {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "ID",unique = true)
	private long id;
	private Date creationDate;
	private String validationKey;
	private boolean passWordAutoGen = false;
	private boolean validated = false;
	private boolean setPerson = false;
	private boolean setCharacter = false;
	private Date lastLogin;
	@OneToOne
	private UserAccount userAccount;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public boolean isPassWordAutoGen() {
		return passWordAutoGen;
	}
	public void setPassWordAutoGen(boolean passWordAutoGen) {
		this.passWordAutoGen = passWordAutoGen;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public String getValidationKey() {
		return validationKey;
	}
	public void setValidationKey(String validationKey) {
		this.validationKey = validationKey;
	}
	public boolean isValidated() {
		return validated;
	}
	public void setValidated(boolean validated) {
		this.validated = validated;
	}
	public boolean isSetPerson() {
		return setPerson;
	}
	public void setSetPerson(boolean setPerson) {
		this.setPerson = setPerson;
	}
	public boolean isSetCharacter() {
		return setCharacter;
	}
	public void setSetCharacter(boolean setCharacter) {
		this.setCharacter = setCharacter;
	}
	public Date getLastLogin() {
		return lastLogin;
	}
	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}
	public UserAccount getUserAccount() {
		return userAccount;
	}
	public void setUserAccount(UserAccount userAccount) {
		this.userAccount = userAccount;
	}
	

}
