package com.tatharo.onelegacy.test.enviroment.container;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import org.springframework.stereotype.Component;

import com.tatharo.onelegacy.spring.dto.baseclasses.ProductBase;
@Component
public class TestClass {

	public static List<ProductBase> productList = new ArrayList<ProductBase>();
	private static long timeRemaining;

	public void addTimedFruit() {
		if(timeRemaining == 0){
		timeRemaining = 15;
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {
				TestClass.removeFalse();
				System.out.println(productList.size());
				if(timeRemaining == -2l){
				timer.cancel();}
				timeRemaining--;
			}
		}, 0l, 60000l);}else{
			timeRemaining = 15;
		}
		
	}

	private static void removeFalse() {
		for (int i = 0, y = (productList.size() - 1); i <= y; y--) {
			if (!productList.get(y).isTimedReserved()) {
				productList.remove(y);
			}
		}

	}

}
