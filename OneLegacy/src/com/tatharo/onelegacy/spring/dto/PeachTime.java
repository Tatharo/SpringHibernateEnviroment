package com.tatharo.onelegacy.spring.dto;

import com.tatharo.onelegacy.spring.dto.baseclasses.ProductBase;

public class PeachTime extends ProductBase{
	private final String peach = "Peach";

	public PeachTime(String userName) {
		super(userName);
		System.out.println(this.getUserName() + " added " + this.peach);
	}

	public String getPeach() {
		return peach;
	}
	

}
