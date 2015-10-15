package com.tatharo.onelegacy.web.jwt.authorization;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.tatharo.onelegacy.spring.config.FixedVariables;

/**
 * 
 * Session Container Class, contains data on all active Json Web Tokens
 *
 */
@Component
public final class ActiveJWTContainer {

	private final List<JWTSessionObject> JWTList = new ArrayList<JWTSessionObject>();

	/**
	 * Creates session object for server side session and creates a unique long
	 * which acts as an ID. Returns long ID to be processed into a Json Web
	 * Token for later authentication with the session container.
	 * 
	 * @param userName
	 *            userName of the logged in account
	 * @return long ID with unique key
	 */
	public synchronized long addJWTSessionObject(String userName) {
		long currentTime = new Date().getTime();
		long authKey = (long) (Math.random() * 1000000000);
		this.removeOutdated(currentTime);
		for (int i = 0; i < JWTList.size(); i++) {
			if (authKey == JWTList.get(i).getAuthenticationId() && authKey == 0L) {
				authKey = (long) (Math.random() * 1000000000);
				i = -1;
				break;
			}
		}
		JWTList.add(new JWTSessionObject(userName, authKey));
		return authKey;
	}

	public boolean authenticateUserRequest(long authKey, String userName) {
		long currentTime = new Date().getTime();
		this.removeOutdated(currentTime);
		for (JWTSessionObject sessionObject : JWTList) {
			if (sessionObject.authenticateJWT(currentTime, authKey, userName))
				return true;
		}
		return false;
	}

	private void removeOutdated(long currentTime) {
		for (int i = 0, y = JWTList.size() - 1; y >= i; y--) {
			if ((currentTime - (FixedVariables.sessionLengthInMinutes * 60 * 1000)) >= JWTList.get(y).getLastUsed()) {
				JWTList.remove(JWTList.get(y));
			}
		}
	}
}