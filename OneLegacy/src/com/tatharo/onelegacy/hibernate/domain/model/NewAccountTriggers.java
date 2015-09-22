package com.tatharo.onelegacy.hibernate.domain.model;

import java.util.Date;

//TODO Triggers after account creation to be validated
public class NewAccountTriggers {
	
	
	private Date creationDate;
	private String validationKey;
	private boolean passWordAutoGen = false;
	private boolean validated = false;
	private boolean setPerson = false;
	private boolean setCharacter = false;
	
	
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
	

}
