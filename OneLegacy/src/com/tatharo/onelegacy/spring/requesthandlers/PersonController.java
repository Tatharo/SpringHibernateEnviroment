package com.tatharo.onelegacy.spring.requesthandlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tatharo.onelegacy.spring.dto.IPersonService;
import com.tatharo.onelegacy.spring.dto.PersonLoginRequestDto;

@RestController
@RequestMapping("/data")
public class PersonController {
	@Autowired
	private IPersonService personService;
	
	@RequestMapping(value = "/person", method = RequestMethod.GET)
	public PersonLoginRequestDto getPersonDetail(@RequestParam(value = "id",required = false,
	                                                    defaultValue = "0") Integer id) {
		PersonLoginRequestDto p = personService.getPersonDetail(id);
		return p;
	}
} 