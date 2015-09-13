package com.tatharo.onelegacy.test.enviroment.container;

import com.tatharo.onelegacy.spring.dto.baseclasses.ProductBase;

public class AppleTime extends ProductBase{
	private final String apple = "Apple";

	public AppleTime(String userName) {
		super(userName);
		System.out.println(this.getUserName() + " added " + apple);
	}
	

}
