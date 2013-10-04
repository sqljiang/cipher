package com.neusoft.encrypt.singet;

import java.security.NoSuchAlgorithmException;

import org.junit.Test;

import com.neusoft.encrypt.singet.md.MDAlgorithm;
import com.neusoft.encrypt.singet.md.MDCoder;
import com.neusoft.encrypt.singet.md.MDEncryption;

public class SingetEncryptionTest {
	
	private static String plain = "git hub";

	@Test
	public void testMDCoder() throws NoSuchAlgorithmException{
		MDCoder coder = new MDCoder();
		byte[] result = coder.encrypt(plain, MDAlgorithm.MD2);
		System.out.println(coder.transform(result));
		result = coder.encrypt(plain, MDAlgorithm.MD5);
		System.out.println(coder.transform(result));
	}
	
	@Test
	public void testMDEncryption() throws NoSuchAlgorithmException{
		MDEncryption encryption = new MDEncryption();
		byte[] result = encryption.encrypt(plain, MDAlgorithm.MD2);
		System.out.println(encryption.transform(result));
		result = encryption.encrypt(plain, MDAlgorithm.MD5);
		System.out.println(encryption.transform(result));
	}
	
}
