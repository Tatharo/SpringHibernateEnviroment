package com.tatharo.onelegacy.web.jwt.authorization;

import java.util.Date;

import com.tatharo.onelegacy.spring.config.FixedVariables;

public final class JWTSessionObject {
	private final String userName;
	private final long authenticationId;
	private long lastUsed;

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
		if (currentTime >= this.lastUsed && (currentTime - (FixedVariables.sessionLengthInMinutes * 60 * 1000)) <= this.lastUsed) {
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