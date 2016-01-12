package com.tatharo.onelegacy.spring.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

//TODO make application form related methods
public final class ApplicationFormDto {

	// UserAccount
	@NotNull
	@Size(min = 4, max = 20)
	private final String userName;
	@NotNull
	@Size(min = 5)
	private final String email;
	@NotNull
	@Size(min = 8, max = 20)
	private final String passWord;
	// Main Character
	@Size(max = 12)
	private final String characterName;
	// dropdown?
	@NotNull
	private final String characterClass;
	// dropdown
	@NotNull
	private final String characterRace;
	// dropdown
	@NotNull
	private final String characterMainSpecialization;
	// dropdown
	@NotNull
	private final String characterOffSpecialization;
	@Size(min = 2)
	private final byte characterLevel;
	// Temporary Application details
	@NotNull
	@Size(min = 3, max = 3)
	private final int itemLevel;
	private final String previousRaidingExperience;

	/**
	 * Data Transfer Object for a guild application, contains enough info to
	 * create a UserAccount.class & WoWCharacter.class if the application is
	 * accepted. Can contain more info for extra account details such as
	 * address.class & Person.class
	 * 
	 * 
	 * 
	 * @param userName
	 * @param email
	 * @param passWord
	 * @param characterName
	 * @param characterClass
	 * @param characterRace
	 * @param characterMainSpecialization
	 * @param characterOffSpecialization
	 * @param characterLevel
	 * @param itemLevel
	 * @param previousRaidingExperience
	 */
	@JsonCreator
	public ApplicationFormDto(@JsonProperty("userName") String userName, @JsonProperty("email") String email,
			@JsonProperty("passWord") String passWord, @JsonProperty("characterName") String characterName,
			@JsonProperty("characterClass") String characterClass, @JsonProperty("characterRace") String characterRace,
			@JsonProperty("characterMainSpecialization") String characterMainSpecialization,
			@JsonProperty("characterOffSpecialization") String characterOffSpecialization,
			@JsonProperty("characterLevel") byte characterLevel, @JsonProperty("itemLevel") int itemLevel,
			@JsonProperty("previousRaidingExperience") String previousRaidingExperience) {
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
