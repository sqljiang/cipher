package com.neusoft.crypt.singet.md;

import java.io.IOException;
import java.io.InputStream;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.lang.Validate;

import com.neusoft.crypt.singet.Encryption;

public class MDEncryption  implements Encryption<MDAlgorithm>{

	@Override
	public byte[] encrypt(byte[] plain, MDAlgorithm algorithm)
			throws NoSuchAlgorithmException {
		Validate.notNull(plain, "the plaint argument should not be null");
		Validate.notNull(algorithm, "the algorithm should not be null");
		if(algorithm == MDAlgorithm.MD4)
			throw new NoSuchAlgorithmException("this method don't support the "+algorithm.getAlogithmValue()+" md algorithm");
		MessageDigest msg = MessageDigest.getInstance(algorithm.getAlogithmValue());
		return msg.digest(plain);
	}

	@Override
	public byte[] encrypt(String plain, MDAlgorithm algorithm)
			throws NoSuchAlgorithmException {
		Validate.notNull(plain, "the plaint argument should not be null");
		byte[] bt = plain.getBytes();
		return encrypt(bt, algorithm);
	}

	@Override
	public byte[] encrypt(InputStream plain, MDAlgorithm algorithm)
			throws IOException, NoSuchAlgorithmException {
		DigestInputStream dis = null;
		if(plain instanceof DigestInputStream) dis = (DigestInputStream) plain;
		else  dis = new DigestInputStream(plain, MessageDigest.getInstance(algorithm.getAlogithmValue()));
		MessageDigest msg = dis.getMessageDigest();
		return msg.digest();
	}

}
