package com.neusoft.crypt.singet;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import org.junit.Test;

import com.neusoft.crypt.singet.mac.MACAlgorithm;
import com.neusoft.crypt.singet.mac.MACEncryption;
import com.neusoft.crypt.singet.md.MDAlgorithm;
import com.neusoft.crypt.singet.md.MDCoder;
import com.neusoft.crypt.singet.md.MDEncryption;
import com.neusoft.crypt.singet.sha.SHAAlgorithm;
import com.neusoft.crypt.singet.sha.SHAEncryption;
import com.neusoft.utils.TransformHandler;

public class SingetEncryptionTest {
	
	private static String plain = "git hub";

	@Test
	public void testMDCoder() throws NoSuchAlgorithmException{
		MDCoder coder = new MDCoder();
		byte[] result = coder.encrypt(plain, MDAlgorithm.MD2);
		System.out.println(TransformHandler.transform(result));
		result = coder.encrypt(plain, MDAlgorithm.MD5);
		System.out.println(TransformHandler.transform(result));
	}
	
	@Test
	public void testMDEncryption() throws NoSuchAlgorithmException{
		MDEncryption encryption = new MDEncryption();
		byte[] result = encryption.encrypt(plain, MDAlgorithm.MD2);
		System.out.println(TransformHandler.transform(result));
		result = encryption.encrypt(plain, MDAlgorithm.MD5);
		System.out.println(TransformHandler.transform(result));
	}
	
	@Test
	public void testSHAEncryption() throws NoSuchAlgorithmException{
		SHAEncryption encryption = new SHAEncryption();
		byte[] result = encryption.encrypt(plain, SHAAlgorithm.SHA512);
		System.out.println(TransformHandler.transform(result));
	}
	
	@Test
	public void testMACEncryption() throws InvalidKeyException, NoSuchAlgorithmException, IllegalStateException{
		MACEncryption mac = new MACEncryption();
		byte[] result = mac.encrypt(plain, MACAlgorithm.HMACSHA512);
		System.out.println(TransformHandler.transform(result));
	}
	
}
