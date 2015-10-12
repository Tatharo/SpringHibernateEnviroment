package com.tatharo.onelegacy.web.jwt.authorization;

import java.security.Key;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * 
 * Class which deals with Json Web Tokens, creating/updating/using
 *
 */
public final class JsonWebTokenCreator {
	/**
	 * Returns an String which contains a Json Web Token (jwt) based on a
	 * userName and authorization key. This key should be generated when a user
	 * logs in. This token will only remain active if used at least once every x
	 * amount of minutes.
	 * 
	 * the returned value is signed with HS256 algorithm
	 * 
	 * @param authKey
	 *            Math random value as identification for the jwt.
	 * @param userName
	 *            The actual user the returned jwt will belong to.
	 * @return String containing a Json Web Token
	 * 
	 */
	public static String createJWT(long authKey, String userName) {

		SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
		byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary("mysecretsecret");
		Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

		JwtBuilder builder = Jwts.builder().setId(authKey + "").setIssuer(userName).signWith(signatureAlgorithm,
				signingKey);

		return builder.compact();
	}

	/**
	 * Returns a Decrypted Json Web Token which can be used for requests which
	 * require authorization.
	 * 
	 * @param jwt
	 *            Json Web Token used for authorization
	 * @return
	 */
	public static CarrierJWTDataObject decryptJWT(String jwt) {

		Claims claims = Jwts.parser().setSigningKey(DatatypeConverter.parseBase64Binary("mysecretsecret"))
				.parseClaimsJws(jwt).getBody();
		return new CarrierJWTDataObject(claims.getIssuer(), Long.parseLong(claims.getId()));
	}

}
