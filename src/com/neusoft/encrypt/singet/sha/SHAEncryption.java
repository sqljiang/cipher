package com.neusoft.encrypt.singet.sha;

import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.lang.Validate;

import com.neusoft.encrypt.singet.Encryption;

public class SHAEncryption implements Encryption<SHAAlgorithm> {

	@Override
	public byte[] encrypt(byte[] plain, SHAAlgorithm algorithm)
			throws NoSuchAlgorithmException {
		Validate.notNull(plain, "the plaint argument should not be null");
		Validate.notNull(algorithm, "the algorithm should not be null");
		if(algorithm == SHAAlgorithm.SHA224)
			throw new NoSuchAlgorithmException("this method don't support the "+algorithm.getAlogithmValue()+" sha algorithm");
		MessageDigest msg = MessageDigest.getInstance(algorithm.getAlogithmValue());
		return msg.digest(plain);
	}

	@Override
	public byte[] encrypt(String plain, SHAAlgorithm algorithm)
			throws NoSuchAlgorithmException {
		Validate.notNull(plain, "the plaint argument should not be null");
		return encrypt(plain.getBytes(), algorithm);
	}

	@Override
	public byte[] encrypt(InputStream plain, SHAAlgorithm algorithm)
			throws IOException, NoSuchAlgorithmException {
		throw new UnsupportedOperationException("encrypt cann't support this method");
	}

	

}
