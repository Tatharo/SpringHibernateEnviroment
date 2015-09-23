package com.tatharo.onelegacy.spring.requesthandlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.tatharo.onelegacy.hibernate.domain.model.ApplicationData;
import com.tatharo.onelegacy.hibernate.domain.repository.ApplicationDataRepository;
import com.tatharo.onelegacy.spring.dto.ApplicationFormDto;

public class ApplicationController {
	private final ApplicationDataRepository applicationDataRepository;

	@Autowired
	public ApplicationController(ApplicationDataRepository applicationDataRepository) {
		super();
		this.applicationDataRepository = applicationDataRepository;
	}

	// TODO: Application creation
	@RequestMapping(value = "guild/application", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ModelAndView createApplication(@RequestBody ApplicationFormDto applicationFormDto) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setView(new MappingJackson2JsonView());
		ApplicationData applicationData = new ApplicationData(applicationFormDto.getUserName(),
				applicationFormDto.getEmail(), applicationFormDto.getPassWord(), applicationFormDto.getCharacterName(),
				applicationFormDto.getCharacterClass(), applicationFormDto.getCharacterRace(),
				applicationFormDto.getCharacterMainSpecialization(), applicationFormDto.getCharacterOffSpecialization(),
				applicationFormDto.getCharacterLevel(), applicationFormDto.getItemLevel(),
				applicationFormDto.getPreviousRaidingExperience());
		applicationDataRepository.saveApplicationData(applicationData);
		return modelAndView;
	}
}
