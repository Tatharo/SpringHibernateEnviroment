package com.tatharo.onelegacy.spring.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public final class AccountDto {
	@NotNull
	@Size(min = 5)
	private final String email;
	@NotNull
	@Size(min = 4, max = 20)
	private final String userName;
	@NotNull
	@Size(min = 8, max = 20)
	private final String passWord;

	@JsonCreator
	public AccountDto(@JsonProperty("email") String email, @JsonProperty("userName") String userName,@JsonProperty("passWord") String passWord) {

		this.email = email;
		this.userName = userName;
		this.passWord = passWord;
	}

	public String getEmail() {
		return email;
	}

	public String getUserName() {
		return userName;
	}

	public String getPassWord() {
		return passWord;
	}

}
