package com.tatharo.onelegacy.spring.requesthandlers;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import static com.tatharo.onelegacy.spring.config.FixedVariables.securityHeader;

import org.apache.commons.validator.routines.EmailValidator;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.tatharo.onelegacy.hibernate.domain.model.UserAccount;
import com.tatharo.onelegacy.hibernate.domain.repository.UserAccountRepository;
import com.tatharo.onelegacy.hibernate.domain.service.UserAccountService;
import com.tatharo.onelegacy.spring.dto.AccountDto;
import com.tatharo.onelegacy.spring.dto.PassWordDto;
import com.tatharo.onelegacy.web.jwt.authorization.CarrierJWTDataObject;
import com.tatharo.onelegacy.web.jwt.authorization.JsonWebTokenCreator;

@RestController
public class AccountController {

	@Autowired
	public AccountController(UserAccountRepository userAccountRepository,UserAccountService userAccountService) {
		this.userAccountRepository = userAccountRepository;
		this.userAccountService= userAccountService;
	}
	private UserAccountService userAccountService;
	private UserAccountRepository userAccountRepository;

	@RequestMapping(value = "account/subscribe", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ModelAndView createAccount(@Valid @RequestBody AccountDto accountDto) {
		boolean startTransaction = true;
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setView(new MappingJackson2JsonView());
		if (EmailValidator.getInstance().isValid(accountDto.getEmail())) {
			try {

				if (userAccountRepository.isEmailAvailable(accountDto.getEmail())) {
					modelAndView.addObject("EmailCheck", "Email is already taken");
					startTransaction = false;
				}
				if (userAccountRepository.isUserNameAvailable(accountDto.getUserName())) {
					modelAndView.addObject("UserNameCheck", "UserName is already taken");
					startTransaction = false;
				}
				if (startTransaction) {
					UserAccount userAccount = new UserAccount(accountDto.getUserName(),
							userAccountService.cryptWithMD5(accountDto.getPassWord()), accountDto.getEmail());
					userAccountRepository.saveUserAccount(userAccount);
					modelAndView.addObject("UserAccount", "Account Created");
				}
			} catch (ConstraintViolationException e) {
				modelAndView.addObject("Exception" + "Failed Transaction: " + e.getCause().getMessage());
				return modelAndView;
			}
		} else {
			modelAndView.addObject("EmailCheck", "Invalid Email");
		}
		return modelAndView;
	}

	@RequestMapping(value = "myaccount/password", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ModelAndView changePassword(HttpServletRequest request, @RequestBody PassWordDto passWordDto) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setView(new MappingJackson2JsonView());
		CarrierJWTDataObject carrierJWTDataObject = null;
		try {
			carrierJWTDataObject = JsonWebTokenCreator.decryptJWT(request.getHeader(securityHeader));
		} catch (io.jsonwebtoken.MalformedJwtException e) {
			modelAndView.addObject("Token Invalid", "No user Logged in");
		}
		if (carrierJWTDataObject != null) {
			UserAccount userAccount = userAccountRepository.getByUserName(carrierJWTDataObject.getUserName());
			if (userAccount.getPassword().equals(userAccountService.cryptWithMD5(passWordDto.getOldPassWord()))) {
				if (passWordDto.getNewPassWordOne().equals(passWordDto.getNewPassWordTwo())) {
					if (!userAccount.getPassword().equalsIgnoreCase(passWordDto.getNewPassWordOne())) {
						userAccount.setPassword(passWordDto.getNewPassWordOne());
						userAccountRepository.updateUserAccount(userAccount);
						modelAndView.addObject("PassWordSucces", "PassWord Succesfully Changed");
					} else {
						modelAndView.addObject("PassWordError", "New PassWord is too similar to Old PassWord");
					}
				} else {
					modelAndView.addObject("PassWordError", "New PassWord Inputs Don't Match");
				}
			} else {
				modelAndView.addObject("PassWordError", "Current PassWord does not match DB");
			}
		}
		return modelAndView;
	}
}
