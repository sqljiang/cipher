package com.neusoft.encrypt.singet.sha;

import com.neusoft.encrypt.singet.Algorithm;

public enum SHAAlgorithm implements Algorithm {

	SHA1("SHA"),
	SHA224("SHA-224"),
	SHA256("SHA-256"),
	SHA384("SHA-384"),
	SHA512("SHA-512");
	
	private String algorithm;
	
	private SHAAlgorithm(String algorithm){
		this.algorithm = algorithm;
	}
	
	public String getAlogithmValue(){
		return this.algorithm;
	}

}
