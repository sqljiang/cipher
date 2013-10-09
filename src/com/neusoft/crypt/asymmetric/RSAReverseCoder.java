package com.neusoft.crypt.asymmetric;

import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import org.apache.commons.lang.Validate;

public class RSAReverseCoder extends AbstractCoder {

	@Override
	public byte[] encrypt(byte[] data, Key key)
			throws NoSuchAlgorithmException, InvalidKeySpecException,
			InvalidKeyException, NoSuchPaddingException,
			IllegalBlockSizeException, BadPaddingException {
		Validate.notNull(data, "the data argument shouldn't be null.");
		return cipher(Cipher.ENCRYPT_MODE, buildPublicKey(key), data);
	}

	@Override
	public byte[] decrypt(byte[] data, Key key)
			throws NoSuchAlgorithmException, InvalidKeySpecException,
			InvalidKeyException, NoSuchPaddingException,
			IllegalBlockSizeException, BadPaddingException {
		Validate.notNull(data, "the data argument shouldn't be null.");
		return cipher(Cipher.DECRYPT_MODE, buildPrivaKey(key), data);
	}

}
