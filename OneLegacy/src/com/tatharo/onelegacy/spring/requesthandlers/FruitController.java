package com.tatharo.onelegacy.spring.requesthandlers;

import java.util.List;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.tatharo.onelegacy.spring.dto.AppleTime;
import com.tatharo.onelegacy.spring.dto.PeachTime;
import com.tatharo.onelegacy.spring.dto.baseclasses.ProductBase;
import com.tatharo.onelegacy.test.enviroment.container.TestClass;

@RestController("/add")
public class FruitController {
	@Autowired
	private TestClass testClass;

	@ResponseBody
	@RequestMapping(value = "/person", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
	public List<ProductBase> getPersonDetail(
			@RequestParam(value = "fruit", required = false, defaultValue = "apple") String fruit,
			@RequestParam(value = "user", required = true) String user) {
		if (fruit.equalsIgnoreCase("apple")) {
			TestClass.productList.add(new AppleTime(user));
		} else {
			TestClass.productList.add(new PeachTime(user));

			testClass.addTimedFruit();
		}
		return TestClass.productList;
	}
}