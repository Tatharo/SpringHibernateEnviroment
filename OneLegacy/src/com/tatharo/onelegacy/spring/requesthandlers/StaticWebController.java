package com.tatharo.onelegacy.spring.requesthandlers;

import static com.tatharo.onelegacy.spring.requesthandlers.config.StaticWebPages.INDEX;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StaticWebController {
	@RequestMapping(value = "hoi")
	public String getTest() {
		return INDEX;
	}
}