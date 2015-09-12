package com.tatharo.onelegacy.spring.requesthandlers;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.tatharo.onelegacy.spring.dto.LoginDto;

@RestController
public class LoginController {
	@RequestMapping(value = "account/login", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ModelAndView startLogin(@RequestBody LoginDto loginDto){
		System.out.println("test Login call");
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("headername", "headerValue");
		ModelAndView modelAndView = new ModelAndView();
		return modelAndView;
	}
}
