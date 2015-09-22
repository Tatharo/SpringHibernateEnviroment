package com.tatharo.onelegacy.spring.dto;

import com.fasterxml.jackson.annotation.JsonCreator;

//TODO make application form related methods
public final class ApplicationFormDto {
	// UserAccount
	private final String userName;
	private final String email;
	private final String passWord;
	// Main Character
	private final String characterName;
	private final String characterClass;
	private final String characterRace;
	private final String characterMainSpecialization;
	private final String characterOffSpecialization;
	private final byte characterLevel;
	// Temporary Application details
	private final int itemLevel;
	private final String previousRaidingExperience;

	@JsonCreator
	public ApplicationFormDto(String userName, String email, String passWord, String characterName,
			String characterClass, String characterRace, String characterMainSpecialization,
			String characterOffSpecialization, byte characterLevel, int itemLevel, String previousRaidingExperience) {
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

	public int getItemLevel() {
		return itemLevel;
	}

	public String getPreviousRaidingExperience() {
		return previousRaidingExperience;
	}

	public String getUserName() {
		return userName;
	}

	public String getEmail() {
		return email;
	}

	public String getPassWord() {
		return passWord;
	}

	public String getCharacterName() {
		return characterName;
	}

	public String getCharacterClass() {
		return characterClass;
	}

	public String getCharacterRace() {
		return characterRace;
	}

	public String getCharacterMainSpecialization() {
		return characterMainSpecialization;
	}

	public String getCharacterOffSpecialization() {
		return characterOffSpecialization;
	}

	public byte getCharacterLevel() {
		return characterLevel;
	}

}
