package com.tatharo.web.jwt.authorization;

import java.util.Date;

import com.tatharo.spring.config.FixedVariables;

public final class JWTSessionObject {
	private final String userName;
	private final long authenticationId;
	private long lastUsed;

	/**
	 * Class containing data to create a server side session
	 * 
	 * @param userName
	 * @param authenticationId
	 */
	public JWTSessionObject(String userName, long authenticationId) {
		this.userName = userName;
		this.authenticationId = authenticationId;
		this.lastUsed = new Date().getTime();
	}

	public long getAuthenticationId() {
		return authenticationId;
	}

	public long getLastUsed() {
		return lastUsed;
	}

	public boolean authenticateJWT(long currentTime, long authKey, String userName) {
		if (currentTime >= this.lastUsed
				&& (currentTime - (FixedVariables.sessionLengthInMinutes * 60 * 1000)) <= this.lastUsed) {
			if (this.userName.equals(userName) && this.authenticationId == authKey) {
				this.lastUsed = currentTime;
				return true;
			} else {
				return false;
			}
		}
		return false;
	}

}