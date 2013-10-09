package com.neusoft;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.Validate;
import org.apache.log4j.Logger;

public class RSABase {
	
	private final static Logger LOG = Logger.getLogger(RSABase.class);
	
	public final static String ALGORITHM = "RSA" ;
	
	public final static String PUBLIC_KEY = "RSAPublicKey" ;
	
	public final static String PRIVATE_KEY = "RSAPrivateKey" ;
	
	private int size = 1024 ;
	
	private String mode ;
	
	public Map<String, Key> buildKeys() throws NoSuchAlgorithmException {
		KeyPairGenerator generator = KeyPairGenerator.getInstance(ALGORITHM);
		generator.initialize(size);
		KeyPair keyPair = generator.generateKeyPair();
		Map<String, Key> store = new HashMap<String, Key>(2);
		store.put(PRIVATE_KEY, keyPair.getPrivate());
		store.put(PUBLIC_KEY, keyPair.getPublic());
		return store;
	}

	public void setSize(int size) throws IllegalArgumentException{
		if(size >= 512 && size <= 65536 && size % 64 == 0)
			this.size = size;
		else 
			throw new IllegalArgumentException("the size is not supported by RSA");
	}
	
	public int getSize(){
		return this.size;
	}

	public String getMode() {
		if(mode == null) return null;
		ObjectInputStream ois = null;
		ObjectOutputStream oos = null;
		String temp = null;
		try {
			ByteArrayOutputStream output = new ByteArrayOutputStream();
			oos = new ObjectOutputStream(output);
			oos.writeObject(mode);
			ByteArrayInputStream input = new ByteArrayInputStream(output.toByteArray());
			ois = new ObjectInputStream(input);
			temp = (String) ois.readObject();
		} catch (IOException e) {
			LOG.error("get the code mode error ",e);
		} catch (ClassNotFoundException e) {
			LOG.error("get the code mode error", e);
		}finally{
			IOUtils.closeQuietly(ois);
			IOUtils.closeQuietly(oos);
		}
		return temp;
	}

	public void setMode(String mode) {
		if(mode == null) return;
		String[] split = mode.split("/");
		if(split == null || split.length != 3) return ;
		if(split[0] == null || !split[0].equalsIgnoreCase("RSA") || split[1] == null || !split[1].equalsIgnoreCase("EBC")) 
			return;
		for(PADDING padding : PADDING.values()){
			if(padding.getPadding().equalsIgnoreCase(split[2])) {
				this.mode = mode;
				LOG.info("config code mode success.Mode is "+this.mode);
				return ;
			}
		}
	}
	
	public static String buildPadding(PADDING padding){
		StringBuilder sb = new StringBuilder();
		sb.append("RSA").append("/");
		sb.append("EBC").append("/");
		sb.append(padding.getPadding());
		return sb.toString();
	}
	
	public static Key buildPublicKey(Key key) throws NoSuchAlgorithmException, InvalidKeySpecException{
		Validate.notNull(key, "the key argument should not be null");
		if(!(key instanceof PublicKey)) throw new IllegalArgumentException("the key argument class error");
		X509EncodedKeySpec spec = new X509EncodedKeySpec(key.getEncoded());
		KeyFactory factory = KeyFactory.getInstance(ALGORITHM);
		return factory.generatePublic(spec);
	}
	
	public static Key buildPrivaKey(Key key) throws NoSuchAlgorithmException, InvalidKeySpecException{
		Validate.notNull(key, "the key argument should not be null");
		if(!(key instanceof PrivateKey)) throw new IllegalArgumentException("the key argument class error");
		PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(key.getEncoded());
		KeyFactory factory = KeyFactory.getInstance(ALGORITHM);
		return factory.generatePrivate(spec);
	}
	
	public static enum PADDING{
		NOPADDING("NoPadding"),
		PKCSPADDING("PKCS1Padding"),
		OAEAPWITHMD5ANDMGF1PADDING("OAEAPWITHMD5AndMGF1Padding"),
		OAEAPWITHSHA1ANDMGF1PADDING("OAEAPWITHSHA1AndMGF1Padding"),
		OAEAPWITHSHA256ANDMGF1PADDING("OAEAPWITHSHA256AndMGF1Padding"),
		OAEAPWITHSHA384ANDMGF1PADDING("OAEAPWITHSHA384AndMGF1Padding"),
		OAEAPWITHSHA512ANDMGF1PADDING("OAEAPWITHSHA512AndMGF1Padding");
		
		private String padding;
		
		private PADDING(String padding){
			this.padding = padding;
		}
		
		public String getPadding(){
			return this.padding;
		}
	}
	
}
