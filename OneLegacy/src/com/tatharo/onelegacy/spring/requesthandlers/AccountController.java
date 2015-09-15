package com.tatharo.onelegacy.spring.requesthandlers;

import javax.validation.Valid;

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
import com.tatharo.onelegacy.spring.dto.AccountDto;
import com.tatharo.onelegacy.spring.dto.PassWordDto;

@RestController
public class AccountController {

	@Autowired
	private UserAccountRepository userAccountRepository;

	@RequestMapping(value = "account/subscribe", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ModelAndView createAccount(@Valid @RequestBody AccountDto accountDto) {
		boolean startTransaction = true;
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setView(new MappingJackson2JsonView());
		if (EmailValidator.getInstance().isValid(accountDto.getEmail())) {
			try {
				UserAccount userAccount = new UserAccount(accountDto.getUserName(), accountDto.getPassWord(),
						accountDto.getEmail());
				if (userAccountRepository.isEmailAvailable(accountDto.getEmail())) {
					modelAndView.addObject("EmailCheck", "Email is already taken");
					startTransaction = false;
				}
				if (userAccountRepository.isUserNameAvailable(accountDto.getUserName())) {
					modelAndView.addObject("UserNameCheck", "UserName is already taken");
					startTransaction = false;
				}
				if (startTransaction) {
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

	@RequestMapping(value = "account/myaccount", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ModelAndView getAccount() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setView(new MappingJackson2JsonView());

		// TODO JWT token Authentication, Requires Login, get userName
		// fromJWT??? or full object
		UserAccount userAccount = userAccountRepository.getByUserName("ssstring22");
		if (userAccount != null) {
			// TODO Password should not be returned right? ^^, mayebe change
			// AccountDto or keep email and username in JWT token
			AccountDto accountDto = new AccountDto(userAccount.getEmail(), userAccount.getUserName(),
					userAccount.getPassword());
			modelAndView.addObject("myUserAccount", accountDto);
		} else {
			modelAndView.addObject("User Error", "User not found, logged out?");
		}
		return modelAndView;

	}
	
	@RequestMapping(value = "account/myaccount", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ModelAndView changePassword(@RequestBody PassWordDto passWordDto){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setView(new MappingJackson2JsonView());
		//TODO save implementation of change password, need to be logged in JWT authentication
		
		
		return modelAndView;
	}
}
