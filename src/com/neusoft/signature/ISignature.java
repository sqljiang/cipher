package com.neusoft.signature;

import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;

public interface ISignature {
	/**
	 * a template method schema for signature
	 * @param data
	 * @param key
	 * @return
	 * @throws NoSuchAlgorithmException 
	 * @throws InvalidKeySpecException 
	 * @throws InvalidKeyException 
	 * @throws SignatureException 
	 */
	byte[] operate(byte[] data,Key key,SIGNATURE algorithm) throws NoSuchAlgorithmException, InvalidKeySpecException, InvalidKeyException, SignatureException;
	/**
	 * a template method schema for verify
	 * @param data
	 * @param key
	 * @param algorithm
	 * @return
	 * @throws NoSuchAlgorithmException
	 * @throws InvalidKeySpecException
	 * @throws InvalidKeyException
	 * @throws SignatureException
	 */
	boolean verify(byte[] data,Key key,SIGNATURE algorithm) throws NoSuchAlgorithmException, InvalidKeySpecException, InvalidKeyException, SignatureException;
	
}
