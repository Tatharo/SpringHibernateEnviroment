package com.tatharo.onelegacy.spring.dto;

import com.fasterxml.jackson.annotation.JsonCreator;

//TODO make application form related methods
public class ApplicationFormDto {
	private final String userName;
	private final String email;
	private final String passWord;

	private final String characterName;
	private final String characterClass;
	private final String characterRace;
	private final String characterMainSpecialization;
	private final String characterOffSpecialization;
	private final byte characterLevel;

	@JsonCreator
	public ApplicationFormDto(String userName, String email, String passWord, String characterName,
			String characterClass, String characterRace, String characterMainSpecialization,
			String characterOffSpecialization, byte characterLevel) {
		this.userName = userName;
		this.email = email;
		this.passWord = passWord;
		this.characterName = characterName;
		this.characterClass = characterClass;
		this.characterRace = characterRace;
		this.characterMainSpecialization = characterMainSpecialization;
		this.characterOffSpecialization = characterOffSpecialization;
		this.characterLevel = characterLevel;
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
