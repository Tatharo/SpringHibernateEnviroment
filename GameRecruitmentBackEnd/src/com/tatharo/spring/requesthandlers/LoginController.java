package com.tatharo.spring.requesthandlers;

import static com.tatharo.spring.config.FixedVariables.securityHeader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.tatharo.hibernate.domain.model.UserAccount;
import com.tatharo.hibernate.domain.repository.UserAccountRepository;
import com.tatharo.hibernate.domain.service.UserAccountService;
import com.tatharo.spring.dto.LoginDto;
import com.tatharo.web.jwt.authorization.ActiveJWTContainer;
import com.tatharo.web.jwt.authorization.JsonWebTokenCreator;

@RestController
public class LoginController {
	private final UserAccountRepository userAccountRepository;
	private final ActiveJWTContainer activeJWTContainer;
	private final UserAccountService userAccountService;
	
	@Autowired
	public LoginController(UserAccountRepository userAccountRepository, ActiveJWTContainer activeJWTContainer, UserAccountService userAccountService) {
		this.userAccountRepository = userAccountRepository;
		this.activeJWTContainer = activeJWTContainer;
		this.userAccountService = userAccountService;
	}

	@RequestMapping(value = "account/login", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public HttpHeaders startLogin(@RequestBody LoginDto loginDto) {
		HttpHeaders httpHeaders = new HttpHeaders();
		UserAccount userAccount;
		if (userAccountRepository.isUserNameAvailable(loginDto.getUserName())) {
			userAccount = userAccountRepository.getByUserName(loginDto.getUserName());
			if (userAccount.getPassword().equals(userAccountService.cryptWithMD5(loginDto.getPassWord()))) {
				long authKey = activeJWTContainer.addJWTSessionObject(loginDto.getUserName());
				httpHeaders.add(securityHeader, JsonWebTokenCreator.createJWT(authKey, loginDto.getUserName()));
			} else {
				httpHeaders.add(securityHeader, "failed");
			}
		}
		return httpHeaders;
	}
}