package com.tatharo.onelegacy.web.jwt.authorization;

/**
 * 
 * Class containing a username and authorization key which is used during
 * authorization of a Json Web Token
 *
 */
public final class CarrierJWTDataObject {
	private final String userName;
	private final long authKey;

	public CarrierJWTDataObject(String userName, long authKey) {
		this.userName = userName;
		this.authKey = authKey;
	}

	public String getUserName() {
		return userName;
	}

	public long getAuthKey() {
		return authKey;
	}

}
