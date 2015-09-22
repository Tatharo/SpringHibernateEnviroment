package com.tatharo.onelegacy.hibernate.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class WoWCharacter {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CHARACTER_ID",unique = true, nullable = false)
	private long id;
	@Column(unique=true)
	private String characterName;
	private String characterClass;
	private String characterRace;
	private String characterMainSpecialization;
	private String characterOffSpecialization;
	private byte characterLevel;
	private GuildRank rank;
	@ManyToOne
	private UserAccount userAccount;


	public WoWCharacter() {
	}

	public WoWCharacter(String characterName, String characterClass, String characterRace,
			String characterMainSpecialization, String characterOffSpecialization, byte characterLevel,
			UserAccount userAccount) {
		this.characterName = characterName;
		this.characterClass = characterClass;
		this.characterRace = characterRace;
		this.characterMainSpecialization = characterMainSpecialization;
		this.characterOffSpecialization = characterOffSpecialization;
		this.characterLevel = characterLevel;
		this.userAccount = userAccount;
		
	}

	public GuildRank getRank() {
		return rank;
	}

	public void setRank(GuildRank rank) {
		this.rank = rank;
	}

	public long getId() {
		return id;
	}

	public UserAccount getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(UserAccount userAccount) {
		this.userAccount = userAccount;
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

}
