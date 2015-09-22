package com.tatharo.onelegacy.spring.requesthandlers;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.tatharo.onelegacy.spring.dto.ApplicationFormDto;

public class ApplicationController {

	//TODO: Application creation
	@RequestMapping(value = "guild/application", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ModelAndView createApplication(@RequestBody ApplicationFormDto applicationFormDto){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setView(new MappingJackson2JsonView());
		return modelAndView;
	}
}
