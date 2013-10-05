package com.neusoft.crypt.symmetric;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class AESCoder {
	
	private final String algorithm = "AES";
	
	private KeyLength len = KeyLength.MIN;
	
	private String cipherAlgorithm = "AES/ECB/PKCS5Padding";
	
	public AESCoder(){
		
	}
	
	public AESCoder(KeyLength len){
		this.len = len;
	}
	
	public AESCoder(String cipherAlgorithm){
		this.cipherAlgorithm = cipherAlgorithm;
	}
	
	public AESCoder(KeyLength len,String cipherAlgorithm){
		this.len = len;
		this.cipherAlgorithm = cipherAlgorithm;
	}
	
	/**
	 * AES encode or decode operation
	 * @param content 
	 * @param key
	 * @param mode Cipher.ENCRYPT_MODE or Cipher.DECRYPT_MODE 
	 * @return
	 * @throws NoSuchAlgorithmException
	 * @throws NoSuchPaddingException
	 * @throws InvalidKeyException
	 * @throws IllegalBlockSizeException
	 * @throws BadPaddingException
	 */
	public byte[] operate(byte[] content,byte[] key,int mode) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException{
		SecretKey secretKey = new SecretKeySpec(key, algorithm);
		Cipher cipher = Cipher.getInstance(cipherAlgorithm);
		cipher.init(mode, secretKey);
		return cipher.doFinal(content);
	}

	public byte[] buildKey() throws NoSuchAlgorithmException{
		KeyGenerator generator = KeyGenerator.getInstance(algorithm);
		generator.init(len.length());
		SecretKey secretKey = generator.generateKey();
		return secretKey.getEncoded();
	}

	public KeyLength getLen() {
		return len;
	}

	public void setLen(KeyLength len) {
		this.len = len;
	}

	public String getCipherAlgorithm() {
		return cipherAlgorithm;
	}

	public void setCipherAlgorithm(String cipherAlgorithm) {
		this.cipherAlgorithm = cipherAlgorithm;
	}
	
}
