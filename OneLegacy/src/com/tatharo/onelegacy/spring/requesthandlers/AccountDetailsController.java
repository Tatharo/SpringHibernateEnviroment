package com.tatharo.onelegacy.spring.requesthandlers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.tatharo.onelegacy.hibernate.domain.model.WoWCharacter;
import com.tatharo.onelegacy.hibernate.domain.repository.CharacterRepository;
import com.tatharo.onelegacy.hibernate.domain.repository.UserAccountRepository;
import com.tatharo.onelegacy.spring.dto.CharacterDto;
import com.tatharo.onelegacy.web.jwt.authorization.ActiveJWTContainer;
import com.tatharo.onelegacy.web.jwt.authorization.CarrierJWTDataObject;
import com.tatharo.onelegacy.web.jwt.authorization.JsonWebTokenCreator;
//Should deal with creating all other objects such as character and link them to account
@Controller
public class AccountDetailsController {
	@Autowired
	public AccountDetailsController(CharacterRepository characterRepository, ActiveJWTContainer activeJWTContainer,UserAccountRepository userAccountRepository){
		this.activeJWTContainer = activeJWTContainer;
		this.characterRepository = characterRepository;
		this.userAccountRepository = userAccountRepository;
	}
	private CharacterRepository characterRepository;
	private ActiveJWTContainer activeJWTContainer;
	private UserAccountRepository userAccountRepository;
	
	@RequestMapping(value = "myaccount/characters", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ModelAndView addCharacter(HttpServletRequest request, @RequestBody CharacterDto characterDto){
		ModelAndView modelAndView = new ModelAndView();
	CarrierJWTDataObject carrierJWTDataObject = null;
	try {
		carrierJWTDataObject = JsonWebTokenCreator.decryptJWT(request.getHeader("Authorization"));
	} catch (io.jsonwebtoken.MalformedJwtException e) {
		modelAndView.addObject("Token Invalid", "No user Logged in");
	}
	if (carrierJWTDataObject != null)
		if (activeJWTContainer.authenticateUserRequest(carrierJWTDataObject.getAuthKey(),
				carrierJWTDataObject.getUserName())) {
			WoWCharacter wowCharacter = new WoWCharacter(characterDto.getCharacterName(),characterDto.getCharacterClass(),characterDto.getCharacterRace(),characterDto.getCharacterMainSpecialization(),characterDto.getCharacterOffSpecialization(),characterDto.getCharacterLevel(),userAccountRepository.getByUserName(carrierJWTDataObject.getUserName()));
			characterRepository.saveCharacterToUserAccount(wowCharacter);
			modelAndView.addObject("Character", "Character Added");
		} else {
			modelAndView.addObject("User Error", "User not found, logged out?");
		}
	
	
	return modelAndView;
	}
}
