package com.neusoft.utils;

import org.apache.commons.codec.binary.Hex;

public class TransformHandler {

	public static String transform(byte[] bt){
		if(bt == null || bt.length <= 0)
			return null;
		return Hex.encodeHexString(bt);
	}
	
}
