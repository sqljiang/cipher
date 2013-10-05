package com.neusoft.crypt.asymmetric;

import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class RSACoder {

	private final static String ALGORITHM = "RSA" ;
	
	public final static String PUBLIC_KEY = "RSAPublicKey" ;
	
	public final static String PRIVATE_KEY = "RSAPrivateKey" ;
	
	private final static int SIZE = 1024 ;
	
	public static byte[] encryptByPublicKey(byte[] data,Key key) throws NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException{
		X509EncodedKeySpec spec = new X509EncodedKeySpec(key.getEncoded());
		KeyFactory factory = KeyFactory.getInstance(ALGORITHM);
		PublicKey pk = factory.generatePublic(spec);
		Cipher cipher = Cipher.getInstance(factory.getAlgorithm());
		cipher.init(Cipher.ENCRYPT_MODE, pk);
		return cipher.doFinal(data);
	}
	
	public static byte[] decryptByPrivateKey(byte[] data,Key key) throws NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException{
		PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(key.getEncoded());
		KeyFactory factory = KeyFactory.getInstance(ALGORITHM);
		PrivateKey pk = factory.generatePrivate(spec);
		Cipher cipher = Cipher.getInstance(factory.getAlgorithm());
		cipher.init(Cipher.DECRYPT_MODE, pk);
		return cipher.doFinal(data);
	}
	
	public static byte[] encryptByPrivateKey(byte[] data,Key key) throws NoSuchAlgorithmException, InvalidKeySpecException, InvalidKeyException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException{
		PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(key.getEncoded());
		KeyFactory factory = KeyFactory.getInstance(ALGORITHM);
		PrivateKey pk = factory.generatePrivate(spec);
		Cipher cipher = Cipher.getInstance(factory.getAlgorithm());
		cipher.init(Cipher.ENCRYPT_MODE, pk);
		return cipher.doFinal(data);
	}
	
	public static byte[] decryptByPublicKey(byte[] data,Key key) throws NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException{
		X509EncodedKeySpec spec = new X509EncodedKeySpec(key.getEncoded());
		KeyFactory factory = KeyFactory.getInstance(ALGORITHM);
		PublicKey pk = factory.generatePublic(spec);
		Cipher cipher = Cipher.getInstance(factory.getAlgorithm());
		cipher.init(Cipher.DECRYPT_MODE, pk);
		return cipher.doFinal(data);
	}
	
	public static Map<String, Key> buildKey() throws NoSuchAlgorithmException{
		KeyPairGenerator kpg = KeyPairGenerator.getInstance(ALGORITHM);
		kpg.initialize(SIZE);
		KeyPair kp = kpg.generateKeyPair();
		Map<String, Key> store = new HashMap<String, Key>();
		store.put(PUBLIC_KEY, kp.getPublic());
		store.put(PRIVATE_KEY, kp.getPrivate());
		return store;
	}
	
}
