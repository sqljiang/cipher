package com.neusoft.crypt.symmetric;

public enum KeyLength {

	MIN(128),
	MEDDLE(192),
	MAX(256);
	
	private int length ;
	
	private KeyLength(int length){
		this.length = length;
	}
	
	public int length(){
		return this.length;
	}
	
}
