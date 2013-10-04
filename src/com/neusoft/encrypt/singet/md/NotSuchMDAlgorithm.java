package com.neusoft.encrypt.singet.md;

public class NotSuchMDAlgorithm extends RuntimeException {

	public NotSuchMDAlgorithm(){
		super();
	}
	
	public NotSuchMDAlgorithm(String msg){
		super(msg);
	}
	
	public NotSuchMDAlgorithm(Throwable t){
		super(t);
	}
	
	public NotSuchMDAlgorithm(String msg,Throwable t){
		super(msg,t);
	}
	
}
