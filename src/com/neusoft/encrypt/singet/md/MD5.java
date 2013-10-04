package com.neusoft.encrypt.singet.md;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.lang.Validate;

public class MD5 {

	private final static String ALGORITHM = "MD5" ;
	
	public byte[] encrypt(byte[] plaint) throws NoSuchAlgorithmException{
		Validate.notNull(plaint, "the argument should not be null");
		MessageDigest msg = MessageDigest.getInstance(ALGORITHM);
		return msg.digest(plaint);
 	}
	
	public byte[] encrypt(String plaint) throws NoSuchAlgorithmException{
		Validate.notNull(plaint, "the argument should not be null");
		return encrypt(plaint.getBytes());
	}
	
}
