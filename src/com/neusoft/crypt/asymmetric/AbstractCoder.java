package com.neusoft.crypt.asymmetric;

import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import com.neusoft.RSABase;

public abstract class AbstractCoder extends RSABase implements ICoder {
	/**
	 * encrypt or decrypt by the RSA algorithm
	 * @param mode
	 * @param key
	 * @param data
	 * @return
	 * @throws NoSuchAlgorithmException
	 * @throws NoSuchPaddingException
	 * @throws InvalidKeyException
	 * @throws IllegalBlockSizeException
	 * @throws BadPaddingException
	 */
	protected byte[] cipher(int mode,Key key,byte[] data) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException{
		Cipher cipher = null;
		if(getMode() == null)cipher = Cipher.getInstance(ALGORITHM);
		else cipher = Cipher.getInstance(getMode());
		cipher.init(mode, key);
		return cipher.doFinal(data);
	}
	
}
