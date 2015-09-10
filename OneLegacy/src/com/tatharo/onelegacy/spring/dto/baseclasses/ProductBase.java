package com.tatharo.onelegacy.spring.dto.baseclasses;

import java.util.Timer;
import java.util.TimerTask;

public class ProductBase {
	private boolean isTimedReserved = true;
	private final String userName;

	
	public ProductBase(String userName) {
		this.userName = userName;
		new Timer().schedule(new TimerTask() {
			  @Override
			  public void run() {
				  isTimedReserved = false;
			  }
			}, 30*1000);
	
	}


	public boolean isTimedReserved() {
		return isTimedReserved;
	}


	public String getUserName() {
		return userName;
	}

	
}
