package com.neusoft.encrypt.singet.sha;

import java.io.IOException;
import java.io.InputStream;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.Validate;

import com.neusoft.encrypt.singet.Encryption;

public class SHACoder implements Encryption<SHAAlgorithm> {

	@Override
	public byte[] encrypt(byte[] plain, SHAAlgorithm algorithm)
			throws NoSuchAlgorithmException {
		Validate.notNull(plain, "the plaint argument should not be null");
		Validate.notNull(algorithm, "the algorithm should not be null");
		switch(algorithm){
			case SHA1 :
				return DigestUtils.sha1(plain);
			case SHA224 :
				throw new NoSuchAlgorithmException("the encryption algorithm of"+algorithm.getAlogithmValue()+" isn't realize.");
			case SHA256 :
				return DigestUtils.sha256(plain);
			case SHA384 :
				return DigestUtils.sha384(plain);
			case SHA512 :
				return DigestUtils.sha512(plain);
			default :
				throw new NoSuchAlgorithmException("the encryption algorithm isn't realize.");
		}
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
		Validate.notNull(plain, "the plaint argument should not be null");
		Validate.notNull(algorithm, "the algorithm should not be null");
		switch(algorithm){
			case SHA1 :
				return DigestUtils.sha1(plain);
			case SHA224 :
				throw new NoSuchAlgorithmException("the encryption algorithm of"+algorithm.getAlogithmValue()+" isn't realize.");
			case SHA256 :
				return DigestUtils.sha256(plain);
			case SHA384 :
				return DigestUtils.sha384(plain);
			case SHA512 :
				return DigestUtils.sha512(plain);
			default :
				throw new NoSuchAlgorithmException("the encryption algorithm isn't realize.");
		}
	}

}
