package com.tatharo.spring.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public final class PassWordDto {
	private final String oldPassWord;
	private final String newPassWordOne;
	private final String newPassWordTwo;
	
	@JsonCreator
	public PassWordDto(@JsonProperty("oldPassWord") String oldPassWord,@JsonProperty("newPassWordOne") String newPassWordOne,@JsonProperty("newPassWordTwo") String newPassWordTwo) {
		this.oldPassWord = oldPassWord;
		this.newPassWordOne = newPassWordOne;
		this.newPassWordTwo = newPassWordTwo;
	}

	public String getOldPassWord() {
		return oldPassWord;
	}

	public String getNewPassWordOne() {
		return newPassWordOne;
	}

	public String getNewPassWordTwo() {
		return newPassWordTwo;
	}
	
	

}
