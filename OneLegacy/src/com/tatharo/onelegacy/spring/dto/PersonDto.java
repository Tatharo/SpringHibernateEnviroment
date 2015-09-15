package com.tatharo.onelegacy.spring.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public final class PersonDto {
	private final String firstName;
	private final String middleName;
	private final String lastname;
	private final String gender;
@JsonCreator
	public PersonDto(@JsonProperty("firstName")String firstName, @JsonProperty("middleName")String middleName,@JsonProperty("lastName") String lastname,
			@JsonProperty("gender") String gender) {
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastname = lastname;
		this.gender = gender;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public String getLastname() {
		return lastname;
	}

	public String getGender() {
		return gender;
	}

}
