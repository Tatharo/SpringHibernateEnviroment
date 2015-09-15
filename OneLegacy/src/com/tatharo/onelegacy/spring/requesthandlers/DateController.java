package com.tatharo.onelegacy.spring.requesthandlers;

import java.sql.Date;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;
//TODO: Remove class or move to test environment
@RestController
public class DateController {
	@RequestMapping(value = "dateget" ,method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView getDate(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setView(new MappingJackson2JsonView());
		Date date = new Date(0l);
		modelAndView.addObject("java.SQL.Date()" ,date);
		java.util.Date date2 = new java.util.Date();
		modelAndView.addObject("java.util.Date()", date2);
		return modelAndView;
	}
	@RequestMapping(value = "dateget", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView setDate(@RequestBody Date date){
		System.out.println(date.getTime());
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setView(new MappingJackson2JsonView());
		
		return modelAndView;
		
	}

}
