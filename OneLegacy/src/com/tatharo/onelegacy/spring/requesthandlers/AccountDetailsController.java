package com.tatharo.onelegacy.spring.requesthandlers;

import javax.servlet.http.HttpServletRequest;
import static com.tatharo.onelegacy.spring.config.FixedVariables.securityHeader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.tatharo.onelegacy.hibernate.domain.model.Person;
import com.tatharo.onelegacy.hibernate.domain.model.UserAccount;
import com.tatharo.onelegacy.hibernate.domain.model.WoWCharacter;
import com.tatharo.onelegacy.hibernate.domain.repository.CharacterRepository;
import com.tatharo.onelegacy.hibernate.domain.repository.UserAccountRepository;
import com.tatharo.onelegacy.spring.dto.AccountDto;
import com.tatharo.onelegacy.spring.dto.CharacterDto;
import com.tatharo.onelegacy.spring.dto.PersonDto;
import com.tatharo.onelegacy.web.jwt.authorization.ActiveJWTContainer;
import com.tatharo.onelegacy.web.jwt.authorization.CarrierJWTDataObject;
import com.tatharo.onelegacy.web.jwt.authorization.JsonWebTokenCreator;

@Controller
public class AccountDetailsController {
	
	@Autowired
	public AccountDetailsController(CharacterRepository characterRepository, ActiveJWTContainer activeJWTContainer,
			UserAccountRepository userAccountRepository) {
		this.activeJWTContainer = activeJWTContainer;
		this.characterRepository = characterRepository;
		this.userAccountRepository = userAccountRepository;
	}

	private final CharacterRepository characterRepository;
	private final ActiveJWTContainer activeJWTContainer;
	private final UserAccountRepository userAccountRepository;

	@RequestMapping(value = "myaccount/useraccount", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ModelAndView getAccount(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setView(new MappingJackson2JsonView());
		CarrierJWTDataObject carrierJWTDataObject = null;
		try {
			carrierJWTDataObject = JsonWebTokenCreator.decryptJWT(request.getHeader(securityHeader));
		} catch (io.jsonwebtoken.MalformedJwtException e) {
			modelAndView.addObject("Token Invalid", "No user Logged in");
		}
		if (carrierJWTDataObject != null)
			if (activeJWTContainer.authenticateUserRequest(carrierJWTDataObject.getAuthKey(),
					carrierJWTDataObject.getUserName())) {
				//TODO FRONT END REQUIREMENTS?
				modelAndView.addObject("myUserAccount", new AccountDto(carrierJWTDataObject.getAuthKey() + "",
						carrierJWTDataObject.getUserName(), carrierJWTDataObject.getUserName()));
			} else {
				modelAndView.addObject("UserError", "User not found, logged out?");
			}
		return modelAndView;
	}

	@RequestMapping(value = "myaccount/characters", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ModelAndView addCharacter(HttpServletRequest request, @RequestBody CharacterDto characterDto) {
		ModelAndView modelAndView = new ModelAndView();
		CarrierJWTDataObject carrierJWTDataObject = null;
		try {
			carrierJWTDataObject = JsonWebTokenCreator.decryptJWT(request.getHeader(securityHeader));
		} catch (io.jsonwebtoken.MalformedJwtException e) {
			modelAndView.addObject("TokenInvalid", "No user Logged in");
		}
		if (carrierJWTDataObject != null)
			if (activeJWTContainer.authenticateUserRequest(carrierJWTDataObject.getAuthKey(),
					carrierJWTDataObject.getUserName())) {
				WoWCharacter wowCharacter = new WoWCharacter(characterDto.getCharacterName(),
						characterDto.getCharacterClass(), characterDto.getCharacterRace(),
						characterDto.getCharacterMainSpecialization(), characterDto.getCharacterOffSpecialization(),
						characterDto.getCharacterLevel(),
						userAccountRepository.getByUserName(carrierJWTDataObject.getUserName()));
				characterRepository.saveCharacterToUserAccount(wowCharacter);
				modelAndView.addObject("Character", "Character Added");
			} else {
				modelAndView.addObject("UserError", "User not found, logged out?");
			}

		return modelAndView;
	}

	@RequestMapping(value = "myaccount/characters", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ModelAndView addCharacter(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setView(new MappingJackson2JsonView());
		CarrierJWTDataObject carrierJWTDataObject = null;
		try {
			carrierJWTDataObject = JsonWebTokenCreator.decryptJWT(request.getHeader(securityHeader));
		} catch (io.jsonwebtoken.MalformedJwtException e) {
			modelAndView.addObject("TokenInvalid", "No user Logged in");
		}
		if (carrierJWTDataObject != null)
			if (activeJWTContainer.authenticateUserRequest(carrierJWTDataObject.getAuthKey(),
					carrierJWTDataObject.getUserName())) {

				UserAccount userAccount = userAccountRepository.getByUserName(carrierJWTDataObject.getUserName());
				// TODO: FRONT END REQUIREMENTS?
				for (WoWCharacter wowChar : userAccount.getCharacters()) {

					modelAndView.addObject(wowChar.getCharacterName(), wowChar.getCharacterClass());
				}
			} else {
				modelAndView.addObject("UserError", "User not found, logged out?");
			}

		return modelAndView;
	}

	@RequestMapping(value = "myaccount/person", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ModelAndView updatePerson(HttpServletRequest request, @RequestBody PersonDto personDto) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setView(new MappingJackson2JsonView());
		CarrierJWTDataObject carrierJWTDataObject = null;
		try {
			carrierJWTDataObject = JsonWebTokenCreator.decryptJWT(request.getHeader(securityHeader));
		} catch (io.jsonwebtoken.MalformedJwtException e) {
			modelAndView.addObject("TokenInvalid", "No user Logged in");
		}
		if (carrierJWTDataObject != null)
			if (activeJWTContainer.authenticateUserRequest(carrierJWTDataObject.getAuthKey(),
					carrierJWTDataObject.getUserName())) {
				UserAccount userAccount = userAccountRepository.getByUserName(carrierJWTDataObject.getUserName());
				userAccount.setPerson(new Person(personDto.getFirstName(), personDto.getMiddleName(),
						personDto.getLastname(), userAccount, personDto.getDateOfBirth(), personDto.getGender()));
				userAccountRepository.updateUserAccount(userAccount);
				modelAndView.addObject("Person", "Created");
			} else {
				modelAndView.addObject("UserError", "User not found, logged out?");
			}
		return modelAndView;
	}
	@RequestMapping(value = "myaccount/person", method = RequestMethod.GET,  produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ModelAndView getPerson(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setView(new MappingJackson2JsonView());
		CarrierJWTDataObject carrierJWTDataObject = null;
		try {
			carrierJWTDataObject = JsonWebTokenCreator.decryptJWT(request.getHeader(securityHeader));
		} catch (io.jsonwebtoken.MalformedJwtException e) {
			modelAndView.addObject("TokenInvalid", "No user Logged in");
		}
		if (carrierJWTDataObject != null)
			if (activeJWTContainer.authenticateUserRequest(carrierJWTDataObject.getAuthKey(),
					carrierJWTDataObject.getUserName())) {
				UserAccount userAccount = userAccountRepository.getByUserName(carrierJWTDataObject.getUserName());
				Person person = userAccount.getPerson();
				modelAndView.addObject(person.getFirstName(), person.getFirstName());
				modelAndView.addObject(person.getMiddleName(), person.getMiddleName());
				modelAndView.addObject(person.getLastName(), person.getLastName());
				// TODO: FRONT END REQUIREMENTS?
			} else {
				modelAndView.addObject("UserError", "User not found, logged out?");
			}
		return modelAndView;
	}
}
