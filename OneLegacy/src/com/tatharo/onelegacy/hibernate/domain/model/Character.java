package com.tatharo.onelegacy.hibernate.domain.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Character {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "ID", unique = true)
	private long id;
	private UserAccount userAccount;
	private String characterName;
	private String characterClass;
	private String characterRace;
	private String characterMainSpecialization;
	private String characterOffSpecialization;
	private byte characterLevel;
	// TODO: How to Assign
	private GuildRank guildRank;

	public Character(long id, String characterName, String characterClass, String characterRace,
			String characterMainSpecialization, String characterOffSpecialization, byte characterLevel,
			UserAccount userAccount) {
		super();
		this.id = id;
		this.characterName = characterName;
		this.characterClass = characterClass;
		this.characterRace = characterRace;
		this.characterMainSpecialization = characterMainSpecialization;
		this.characterOffSpecialization = characterOffSpecialization;
		this.characterLevel = characterLevel;
		this.guildRank = GuildRank.NEWMEMBER;
		this.userAccount = userAccount;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public GuildRank getGuildRank() {
		return guildRank;
	}

	public void setGuildRank(GuildRank guildRank) {
		this.guildRank = guildRank;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userId", nullable = false)
	public UserAccount getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(UserAccount userAccount) {
		this.userAccount = userAccount;
	}
}
