package com.tatharo.onelegacy.hibernate.domain.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

import org.springframework.stereotype.Component;

//import javax.activation.*;
//TODO: UNUSED CODE!!!! PLEASE FINISH
@Component
public class UserAccountService {
	public void sendMail() {
		String to = "eric.jan.vandermark@gmail.com";
		String from = "web@tatharo.com";
		String host = "localhost";
		Properties properties = System.getProperties();
		properties.setProperty("mail.smtp.host", host);
		Session session = Session.getDefaultInstance(properties);

		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setSubject("This is the Subject Line!");
			message.setText("This is actual message");
			Transport.send(message);
			System.out.println("Sent message successfully....");
		} catch (MessagingException mex) {
			System.out.println("hoi");
			mex.printStackTrace();
		}
	}

	public String cryptWithMD5(String pass) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] passBytes = pass.getBytes();
			md.reset();
			byte[] digested = md.digest(passBytes);
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < digested.length; i++) {
				sb.append(Integer.toHexString(0xff & digested[i]));
			}
			return sb.toString();
		} catch (NoSuchAlgorithmException ex) {
			ex.printStackTrace();
		}
		return null;
	}
}