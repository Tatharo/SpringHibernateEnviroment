package com.tatharo.onelegacy.spring.dto;

import org.springframework.stereotype.Component;

@Component
public class PersonService implements IPersonService {
	@Override
	public PersonLoginRequestDto getPersonDetail(Integer id){
		PersonLoginRequestDto p = new PersonLoginRequestDto(id,"Varanasi","Ram");
		return p;
	}
}