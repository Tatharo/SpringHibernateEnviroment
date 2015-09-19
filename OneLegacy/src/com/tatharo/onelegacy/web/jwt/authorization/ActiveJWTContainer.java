package com.tatharo.onelegacy.web.jwt.authorization;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tatharo.onelegacy.hibernate.domain.repository.UserAccountRepository;
import com.tatharo.onelegacy.spring.config.FixedVariables;

@Component
public final class ActiveJWTContainer {
	@Autowired
	public ActiveJWTContainer(UserAccountRepository userAccountRepository) {
		this.userAccountRepository = userAccountRepository;
	}

	private UserAccountRepository userAccountRepository;

	private List<JWTSessionObject> JWTList = new ArrayList<JWTSessionObject>();

	public long addJWTSessionObject(String userName) {
		if (!userAccountRepository.isUserNameAvailable(userName)) {
			long currentTime = new Date().getTime();
			long authKey = (long) (Math.random() * 1000000000);
			this.removeOutdated(currentTime);
			for (int i = 0; i < JWTList.size(); i++) {
				while (authKey == JWTList.get(i).getAuthenticationId() && authKey == 0L) {
					authKey = (long) (Math.random() * 1000000000);
					i = -1;
					break;
				}
			}
			JWTList.add(new JWTSessionObject(userName, authKey));
			return authKey;
		}return 0L;
	}
	
	public boolean authenticateUserRequest(long authKey, String userName){
		long currentTime = new Date().getTime();
		this.removeOutdated(currentTime);
		for(JWTSessionObject sessionObject : JWTList){
			if(sessionObject.authenticateJWT(currentTime, authKey, userName))
				return true;
			}
		return false;
	}

	private void removeOutdated(long currentTime) {
		System.out.println(JWTList.size());
		for(JWTSessionObject jwtSessionObject : JWTList ){
			if ((currentTime - (FixedVariables.sessionLengthInMinutes * 60 * 1000)) >= jwtSessionObject.getLastUsed()) {
				JWTList.remove(jwtSessionObject);
		}
		System.out.println(JWTList.size());
		

	}
}}