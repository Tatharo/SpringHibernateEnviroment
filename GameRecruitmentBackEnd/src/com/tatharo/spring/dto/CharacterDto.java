package com.tatharo.spring.dto;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public final class CharacterDto {
	@NotNull
	private final String characterName;
	@NotNull
	private final String characterClass;
	@NotNull
	private final String characterRace;
	@NotNull
	private final String characterMainSpecialization;
	private final String characterOffSpecialization;
	@NotNull
	private final byte characterLevel;

	@JsonCreator
	public CharacterDto(
			@JsonProperty("characterName") String characterName,
			@JsonProperty("characterClass") String characterClass,
			@JsonProperty("characterRace") String characterRace,
			@JsonProperty("characterMainSpecialization") String characterMainSpecialization,
			@JsonProperty("characterOffSpecialization") String characterOffSpecialization,
			@JsonProperty("characterLevel") byte characterLevel){
		this.characterName = characterName;
		this.characterClass = characterClass;
		this.characterRace = characterRace;
		this.characterMainSpecialization = characterMainSpecialization;
		this.characterOffSpecialization = characterOffSpecialization;
		this.characterLevel = characterLevel;


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
