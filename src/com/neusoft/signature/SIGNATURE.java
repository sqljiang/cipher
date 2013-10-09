package com.neusoft.signature;

public  enum SIGNATURE {
	MD2WITHRSA("MD2withRSA"),
	MD5WITHRSA("MD5withRSA"),
	SHAWITHRSA("SHA1withRSA");
	
	private String algorithm;
	
	private SIGNATURE(String algorithm){
		this.algorithm = algorithm;
	}
	
	public String getAlgorithm(){
		return this.algorithm;
	}
}
