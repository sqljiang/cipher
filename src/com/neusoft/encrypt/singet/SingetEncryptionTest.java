package com.neusoft.encrypt.singet;

import java.security.NoSuchAlgorithmException;

import org.junit.Test;

import com.neusoft.encrypt.singet.md.MDAlgorithm;
import com.neusoft.encrypt.singet.md.MDCoder;
import com.neusoft.encrypt.singet.md.MDEncryption;
import com.neusoft.encrypt.singet.sha.SHAAlgorithm;
import com.neusoft.encrypt.singet.sha.SHAEncryption;
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
	
}
