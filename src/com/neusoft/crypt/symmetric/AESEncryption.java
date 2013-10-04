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

public class AESEncryption {
	
	private final String algorithm = "AES";
	
	private KeyLength len = KeyLength.MIN;
	
	private String cipherAlgorithm = "AES/ECB/PKCS5Padding";
	
	public AESEncryption(){
		
	}
	
	public AESEncryption(KeyLength len){
		this.len = len;
	}
	
	public AESEncryption(String cipherAlgorithm){
		this.cipherAlgorithm = cipherAlgorithm;
	}
	
	public AESEncryption(KeyLength len,String cipherAlgorithm){
		this.len = len;
		this.cipherAlgorithm = cipherAlgorithm;
	}
	
	public byte[] encrypt(byte[] plain,byte[] key) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException{
		SecretKey secretKey = new SecretKeySpec(key, algorithm);
		Cipher cipher = Cipher.getInstance(cipherAlgorithm);
		cipher.init(Cipher.ENCRYPT_MODE, secretKey);
		return cipher.doFinal(plain);
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
