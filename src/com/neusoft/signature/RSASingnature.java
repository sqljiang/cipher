package com.neusoft.signature;

import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.interfaces.RSAPrivateKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class RSASingnature {
	
	public static enum SIGNATURE {
		MD2WITHRSA("MD2withRSA"),
		MD5WITHRSA("MD5widthRSA"),
		SHAWITHRSA("SHA1widthRSA");
		
		private String algorithm;
		
		private SIGNATURE(String algorithm){
			this.algorithm = algorithm;
		}
		
		public String getAlgorithm(){
			return this.algorithm;
		}
	}

	private final static String ALGORITHM = "RSA";
	
	public final static String PRIVATE_KEY ="RSAPrivateKey";
	
	public final static String PUBLIC_KEY ="RASPublicKey";
	
	private final static int SIZE = 1024;
	
	public byte[] sign(byte[] data,PrivateKey key) throws NoSuchAlgorithmException, InvalidKeyException, SignatureException, InvalidKeySpecException{
		PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(key.getEncoded());
		KeyFactory factory = KeyFactory.getInstance(ALGORITHM);
		PrivateKey pk = factory.generatePrivate(spec);
		Signature signature = Signature.getInstance(SIGNATURE.MD2WITHRSA.getAlgorithm());
		signature.initSign(pk);
		signature.update(data);
		return signature.sign();
	}
	
	public boolean virefy(byte[] data,byte[] sign,PublicKey key) throws NoSuchAlgorithmException, InvalidKeyException, SignatureException, InvalidKeySpecException{
		X509EncodedKeySpec spec = new X509EncodedKeySpec(key.getEncoded());
		KeyFactory factory = KeyFactory.getInstance(ALGORITHM);
		PublicKey pk = factory.generatePublic(spec);
		Signature signature = Signature.getInstance(SIGNATURE.MD2WITHRSA.getAlgorithm());
		signature.initVerify(pk);
		signature.update(data);
		return signature.verify(sign);
	}
	
	public Map<String, Key> buildKey() throws NoSuchAlgorithmException{
		KeyPairGenerator generator = KeyPairGenerator.getInstance(ALGORITHM);
		generator.initialize(SIZE);
		KeyPair keyPair = generator.generateKeyPair();
		Map<String, Key> store = new HashMap<String, Key>(2);
		store.put(PRIVATE_KEY, keyPair.getPrivate());
		store.put(PUBLIC_KEY, keyPair.getPublic());
		return store;
	}
	
	@Test
	public void test()throws Exception{
		String plain = "git hub";
		RSASingnature rsa = new RSASingnature();
		Map<String, Key> store = rsa.buildKey();
		RSAPrivateKey key = (RSAPrivateKey) store.get(PRIVATE_KEY);
		byte[] result = rsa.sign(plain.getBytes(), key);
//		System.out.println(Hex.encodeHexString(result));
		PublicKey pk = (PublicKey) store.get(PUBLIC_KEY);
		System.out.println(rsa.virefy(plain.getBytes(), result, pk));
		
	}
	
}
