package com.neusoft.signature;

import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;

import com.neusoft.RSABase;

public class RSASignature extends RSABase implements ISignature {

	@Override
	public byte[] operate(byte[] data, Key key, SIGNATURE algorithm)
			throws NoSuchAlgorithmException, InvalidKeySpecException,
			InvalidKeyException, SignatureException {
		if(!(key instanceof PrivateKey)) key = buildPrivaKey(key);
		Signature signature = Signature.getInstance(algorithm.getAlgorithm());
		signature.initSign((PrivateKey)key);
		signature.update(data);
		return signature.sign();
	}

	@Override
	public boolean verify(byte[] data, Key key, SIGNATURE algorithm)
			throws NoSuchAlgorithmException, InvalidKeySpecException,
			InvalidKeyException, SignatureException {
		boolean flag = false;
		if(!(key instanceof PublicKey)) key = buildPublicKey(key);
		Signature signature = Signature.getInstance(algorithm.getAlgorithm());
		signature.initVerify((PublicKey) key);
		flag = signature.verify(data);
		return flag;
	}
	
}
