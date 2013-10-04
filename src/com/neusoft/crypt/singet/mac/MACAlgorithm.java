package com.neusoft.crypt.singet.mac;

import com.neusoft.crypt.singet.Algorithm;

public enum MACAlgorithm implements Algorithm {
	HMACMD5("HmacMD5"),
	HMACSHA1("HmacSHA1"),
	HMACSHA256("HmacSHA256"),
	HMACSHA384("HmacSHA384"),
	HMACSHA512("HmacSHA512");
	
	private String algorithm;
	
	private MACAlgorithm(String algorithm){
		this.algorithm = algorithm;
	}

	@Override
	public String getAlogithmValue() {
		return this.algorithm;
	}

}
