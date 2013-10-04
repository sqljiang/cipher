package com.neusoft.encrypt.singet.mac;

import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.lang.Validate;

import com.neusoft.encrypt.singet.Encryption;

public class MACEncryption implements Encryption<MACAlgorithm> {

	@Override
	public byte[] encrypt(byte[] plain, MACAlgorithm algorithm)
			throws NoSuchAlgorithmException, InvalidKeyException, IllegalStateException {
		Validate.notNull(plain, "the plaint argument should not be null");
		Validate.notNull(algorithm, "the algorithm should not be null");
		return buildMac(algorithm).doFinal(plain);
	}

	@Override
	public byte[] encrypt(String plain, MACAlgorithm algorithm)
			throws NoSuchAlgorithmException, InvalidKeyException, IllegalStateException {
		Validate.notNull(plain, "the plaint argument should not be null");
		return buildMac(algorithm).doFinal(plain.getBytes());
	}

	@Override
	public byte[] encrypt(InputStream plain, MACAlgorithm algorithm)
			throws IOException, NoSuchAlgorithmException {
		throw new UnsupportedOperationException("encrypt cann't support this method");
	}
	
	private Mac buildMac(MACAlgorithm algorithm) throws NoSuchAlgorithmException, InvalidKeyException{
		String am = algorithm.getAlogithmValue();
		KeyGenerator generator = KeyGenerator.getInstance(am);
		SecretKey secretKey = generator.generateKey();
		byte[] key = secretKey.getEncoded();
		secretKey = new SecretKeySpec(key,secretKey.getAlgorithm());
		Mac mac = Mac.getInstance(am);
		mac.init(secretKey);
		return mac;
	}

}
