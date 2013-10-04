package com.neusoft.encrypt.singet.md;

import org.apache.commons.codec.binary.Hex;

public abstract class AbstractEncryption implements Encryption {

	public String transform(byte[] bt){
		if(bt == null || bt.length <= 0) return null;
		return Hex.encodeHexString(bt);
	}
	
}
