package com.tatharo.onelegacy.hibernate.domain.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 
 * Class dealing with applications on the site contains the basic info to create
 * an UserAccount & WoWCharacter if accepted.
 *
 */
public final class ApplicationData {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "ID", unique = true)
	private long id;
	private boolean applicationSeen;
	private boolean applicationAccepted;
	// UserAccount
	private String userName;
	private String email;
	private String passWord;
	// Main WoWCharacter
	private String characterName;
	private String characterClass;
	private String characterRace;
	private String characterMainSpecialization;
	private String characterOffSpecialization;
	private byte characterLevel;
	// Temporary Application details
	private int itemLevel;
	private String previousRaidingExperience;

	public ApplicationData() {
	}

	public ApplicationData(String userName, String email, String passWord, String characterName, String characterClass,
			String characterRace, String characterMainSpecialization, String characterOffSpecialization,
			byte characterLevel, int itemLevel, String previousRaidingExperience) {
		this.applicationSeen = false;
		this.applicationAccepted = false;
		this.userName = userName;
		this.email = email;
		this.passWord = passWord;
		this.characterName = characterName;
		this.characterClass = characterClass;
		this.characterRace = characterRace;
		this.characterMainSpecialization = characterMainSpecialization;
		this.characterOffSpecialization = characterOffSpecialization;
		this.characterLevel = characterLevel;
		this.itemLevel = itemLevel;
		this.previousRaidingExperience = previousRaidingExperience;
	}

	public long getId() {
		return id;
	}

	public boolean isApplicationSeen() {
		return applicationSeen;
	}

	public void setApplicationSeen(boolean applicationSeen) {
		this.applicationSeen = applicationSeen;
	}

	public boolean isApplicationAccepted() {
		return applicationAccepted;
	}

	public void setApplicationAccepted(boolean applicationAccepted) {
		this.applicationAccepted = applicationAccepted;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getCharacterName() {
		return characterName;
	}

	public void setCharacterName(String characterName) {
		this.characterName = characterName;
	}

	public String getCharacterClass() {
		return characterClass;
	}

	public void setCharacterClass(String characterClass) {
		this.characterClass = characterClass;
	}

	public String getCharacterRace() {
		return characterRace;
	}

	public void setCharacterRace(String characterRace) {
		this.characterRace = characterRace;
	}

	public String getCharacterMainSpecialization() {
		return characterMainSpecialization;
	}

	public void setCharacterMainSpecialization(String characterMainSpecialization) {
		this.characterMainSpecialization = characterMainSpecialization;
	}

	public String getCharacterOffSpecialization() {
		return characterOffSpecialization;
	}

	public void setCharacterOffSpecialization(String characterOffSpecialization) {
		this.characterOffSpecialization = characterOffSpecialization;
	}

	public byte getCharacterLevel() {
		return characterLevel;
	}

	public void setCharacterLevel(byte characterLevel) {
		this.characterLevel = characterLevel;
	}

	public int getItemLevel() {
		return itemLevel;
	}

	public void setItemLevel(int itemLevel) {
		this.itemLevel = itemLevel;
	}

	public String getPreviousRaidingExperience() {
		return previousRaidingExperience;
	}

	public void setPreviousRaidingExperience(String previousRaidingExperience) {
		this.previousRaidingExperience = previousRaidingExperience;
	}

}
