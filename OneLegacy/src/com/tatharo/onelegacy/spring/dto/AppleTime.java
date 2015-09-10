package com.tatharo.onelegacy.spring.dto;

import com.tatharo.onelegacy.spring.dto.baseclasses.ProductBase;

public class AppleTime extends ProductBase{
	private final String apple = "Apple";

	public AppleTime(String userName) {
		super(userName);
		System.out.println(this.getUserName() + " added " + apple);
	}
	

}
