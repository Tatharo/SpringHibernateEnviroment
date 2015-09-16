package com.tatharo.onelegacy.spring.requesthandlers;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.tatharo.onelegacy.spring.dto.LoginDto;

@RestController
public class LoginController {
	@RequestMapping(value = "account/login", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public HttpHeaders startLogin(@RequestBody LoginDto loginDto){
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("headername", "headerValue");
		//TODO: should return authorization header with JWT token
		return httpHeaders;
	}
}
