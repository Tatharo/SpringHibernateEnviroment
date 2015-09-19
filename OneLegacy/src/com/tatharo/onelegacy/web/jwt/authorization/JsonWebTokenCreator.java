package com.tatharo.onelegacy.web.jwt.authorization;

import java.security.Key;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public final class JsonWebTokenCreator {
	public static String createJWT(long authKey, String userName) {

		SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
		byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary("mysecretsecret");
		Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

		JwtBuilder builder = Jwts.builder().setId(authKey + "").setIssuer(userName).signWith(signatureAlgorithm,
				signingKey);

		return builder.compact();
	}

	public static CarrierJWTDataObject decryptJWT(String jwt) {
		
		Claims claims = Jwts.parser().setSigningKey(DatatypeConverter.parseBase64Binary("mysecretsecret"))
				.parseClaimsJws(jwt).getBody();
		return new CarrierJWTDataObject( claims.getIssuer(), Long.parseLong(claims.getId()));
	}

}
