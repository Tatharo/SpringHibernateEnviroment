package com.tatharo.spring.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public final class LoginDto {
	private final String userName;
	private final String passWord;
	@JsonCreator
	public LoginDto(@JsonProperty("userName") String userName, @JsonProperty("passWord") String passWord) {
		this.userName = userName;
		this.passWord = passWord;
	}

	public String getUserName() {
		return userName;
	}

	public String getPassWord() {
		return passWord;
	}
	

}
