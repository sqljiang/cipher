package com.neusoft.encrypt.singet.md;

import com.neusoft.encrypt.singet.Algorithm;

/**
 * 
 * the MD algorithm type of java
 * 
 * @author 蒋远龙
 *
 */
public enum MDAlgorithm implements Algorithm{

	MD2("MD2"),
	MD4("MD4"),
	MD5("MD5");
	
	private String alorithm;
	
	private MDAlgorithm(String algorithm){
		this.alorithm = algorithm;
	}
	
	public String getAlogithmValue(){
		return this.alorithm;
	}
	
}
