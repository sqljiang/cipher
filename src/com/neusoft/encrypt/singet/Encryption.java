package com.neusoft.encrypt.singet;

import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public interface Encryption<T extends Enum<? extends Algorithm>> {
	/**
	 * encrypt byte array data by all kinds of MD algorithm
	 * @param plain
	 * @param algorithm
	 * @return
	 * @throws IllegalStateException 
	 * @throws InvalidKeyException 
	 * @throws NotSuchMDAlgorithm
	 */
	public byte[] encrypt(byte[] plain,T algorithm)throws NoSuchAlgorithmException, InvalidKeyException, IllegalStateException;
	/**
	 * encrypt string data by all kinds of MD algorithm
	 * @param plaint
	 * @param algorithm
	 * @return
	 * @throws IllegalStateException 
	 * @throws InvalidKeyException 
	 * @throws NotSuchMDAlgorithm
	 */
	public byte[] encrypt(String plain,T algorithm)throws NoSuchAlgorithmException, InvalidKeyException, IllegalStateException;
	/**
	 * encrypt input stream by all kinds of MD algorithm
	 * @param input
	 * @param algorithm 
	 * @warn encrypt plain input stream isn't be closed
	 * @return
	 * @throws IOException
	 */
	public byte[] encrypt(InputStream plain,T algorithm) throws IOException,NoSuchAlgorithmException;
	
}
