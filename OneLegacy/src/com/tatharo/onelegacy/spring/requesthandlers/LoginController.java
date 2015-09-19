package com.tatharo.onelegacy.spring.requesthandlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.tatharo.onelegacy.hibernate.domain.model.UserAccount;
import com.tatharo.onelegacy.hibernate.domain.repository.UserAccountRepository;
import com.tatharo.onelegacy.spring.dto.LoginDto;
import com.tatharo.onelegacy.web.jwt.authorization.ActiveJWTContainer;
import com.tatharo.onelegacy.web.jwt.authorization.JsonWebTokenCreator;

@RestController
public class LoginController {
	private UserAccountRepository userAccountRepository;
	private ActiveJWTContainer activeJWTContainer;
	@Autowired
	public LoginController(UserAccountRepository userAccountRepository,ActiveJWTContainer activeJWTContainer) {
		this.userAccountRepository = userAccountRepository;
		this.activeJWTContainer = activeJWTContainer;
	}

	@RequestMapping(value = "account/login", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public HttpHeaders startLogin(@RequestBody LoginDto loginDto) {
		// TODO: Maybe create service layer so repositories are not in the
		// actual REST calls
		HttpHeaders httpHeaders = new HttpHeaders();
		UserAccount userAccount = userAccountRepository.getByUserName(loginDto.getUserName());
		long authKey; 

		if (userAccount.getPassword().equals(loginDto.getPassWord())) {
			authKey = activeJWTContainer.addJWTSessionObject(loginDto.getUserName());

			httpHeaders.add("Authorization", JsonWebTokenCreator.createJWT(authKey, loginDto.getUserName()));
		} else {
			// Maybe no header returned and/or server side check for multiple
			// failed login attempts
			httpHeaders.add("Authorization", "failed");
		}
		// TODO: should return authorization header with JWT token
		return httpHeaders;

	}

}
