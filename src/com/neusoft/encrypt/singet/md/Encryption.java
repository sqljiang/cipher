package com.neusoft.encrypt.singet.md;

import java.io.IOException;
import java.io.InputStream;
import java.security.NoSuchAlgorithmException;

public interface Encryption {
	/**
	 * encrypt byte array data by all kinds of MD algorithm
	 * @param plain
	 * @param algorithm
	 * @return
	 * @throws NotSuchMDAlgorithm
	 */
	public byte[] encrypt(byte[] plain,MDAlgorithm algorithm)throws NoSuchAlgorithmException;
	/**
	 * encrypt string data by all kinds of MD algorithm
	 * @param plaint
	 * @param algorithm
	 * @return
	 * @throws NotSuchMDAlgorithm
	 */
	public byte[] encrypt(String plain,MDAlgorithm algorithm)throws NoSuchAlgorithmException;
	/**
	 * encrypt input stream by all kinds of MD algorithm
	 * @param input
	 * @param algorithm 
	 * @warn encrypt plain input stream isn't be closed
	 * @return
	 * @throws IOException
	 */
	public byte[] encrypt(InputStream plain,MDAlgorithm algorithm) throws IOException,NoSuchAlgorithmException;
	/**
	 * byte array data transform to string .if array is null or it's length less or equal zero ,then return null.
	 * @param bt
	 * @return
	 */
	public String transform(byte[] bt);
	
}
