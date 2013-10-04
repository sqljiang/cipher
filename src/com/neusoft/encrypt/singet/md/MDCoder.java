package com.neusoft.encrypt.singet.md;

import java.io.IOException;
import java.io.InputStream;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.Validate;

import com.neusoft.encrypt.singet.Encryption;

public class MDCoder implements Encryption<MDAlgorithm> {
	@Override
	public byte[] encrypt(byte[] plain,MDAlgorithm algorithm)throws NoSuchAlgorithmException{
		Validate.notNull(plain, "the plaint argument should not be null");
		Validate.notNull(algorithm, "the algorithm should not be null");
		switch(algorithm){
			case MD2 :
				return DigestUtils.md2(plain);
			case MD4 :
				return null;
			case MD5 :
				return DigestUtils.md5(plain);
			default :
				throw new NoSuchAlgorithmException("this method don't support the "+algorithm.getAlogithmValue()+" md algorithm");
		}
	}
	
	@Override
	public byte[] encrypt(String plain,MDAlgorithm algorithm)throws NoSuchAlgorithmException{
		Validate.notNull(plain, "the plaint argument should not be null");
		byte[] bt = plain.getBytes();
		return encrypt(bt, algorithm);
	}
	
	@Override
	public byte[] encrypt(InputStream plain,MDAlgorithm algorithm) throws IOException, NoSuchAlgorithmException{
		Validate.notNull(plain, "the input argument should not be null");
		Validate.notNull(algorithm, "the algorithm should not be null");
		switch(algorithm){
			case MD2 :
				return DigestUtils.md2(plain);
			case MD4 :
				return null;
			case MD5 :
				return DigestUtils.md5(plain);
			default :
				throw new NoSuchAlgorithmException("this method don't support the "+algorithm.getAlogithmValue()+" md algorithm");
		}
	}
	
}
