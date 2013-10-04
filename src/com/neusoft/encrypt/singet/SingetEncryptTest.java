package com.neusoft.encrypt.singet;

import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.binary.Hex;
import org.junit.Test;

import com.neusoft.encrypt.singet.md.MD2;
import com.neusoft.encrypt.singet.md.MD5;

public class SingetEncryptTest {

	private static String plaint ="git hub";
	
	@Test
	public void testMD2() throws NoSuchAlgorithmException{
		MD2 md2 = new MD2();
		System.out.println(Hex.encodeHexString(md2.encrypt(plaint)));
	}
	
	@Test
	public void testMD5() throws NoSuchAlgorithmException{
		MD5 md5 = new MD5();
		System.out.println(Hex.encodeHexString(md5.encrypt(plaint)));
	}
	
}
