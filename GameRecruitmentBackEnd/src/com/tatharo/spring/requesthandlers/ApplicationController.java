package com.tatharo.spring.requesthandlers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.tatharo.hibernate.domain.model.ApplicationData;
import com.tatharo.hibernate.domain.repository.ApplicationDataRepository;
import com.tatharo.spring.dto.ApplicationFormDto;

public class ApplicationController {
	private final ApplicationDataRepository applicationDataRepository;

	@Autowired
	public ApplicationController(ApplicationDataRepository applicationDataRepository) {
		super();
		this.applicationDataRepository = applicationDataRepository;
	}

	// TODO: Application creation
	@RequestMapping(value = "guild/application", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ModelAndView createApplication(@Valid @RequestBody ApplicationFormDto applicationFormDto) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setView(new MappingJackson2JsonView());
		// TODO should be validated and notify officers/GM
		applicationDataRepository.saveObject(new ApplicationData(applicationFormDto.getUserName(),
				applicationFormDto.getEmail(), applicationFormDto.getPassWord(), applicationFormDto.getCharacterName(),
				applicationFormDto.getCharacterClass(), applicationFormDto.getCharacterRace(),
				applicationFormDto.getCharacterMainSpecialization(), applicationFormDto.getCharacterOffSpecialization(),
				applicationFormDto.getCharacterLevel(), applicationFormDto.getItemLevel(),
				applicationFormDto.getPreviousRaidingExperience()));
		return modelAndView;
	}

	// TODO authentication and decide if this is a backend task or front end
	@RequestMapping(value = "guild/applications", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ModelAndView createApplication(@RequestParam("applicationId") long id) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setView(new MappingJackson2JsonView());
		// applicationDataRepository.updateObject(t);
		return modelAndView;
	}
}
