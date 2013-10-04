package com.neusoft.encrypt.singet.md;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.Validate;

public class MDCoder {
	/**
	 * encrypt byte array data by all kinds of MD algorithm
	 * @param plain
	 * @param algorithm
	 * @return
	 * @throws NotSuchMDAlgorithm
	 */
	public byte[] encrypt(byte[] plain,MDAlgorithm algorithm)throws NotSuchMDAlgorithm{
		Validate.notNull(plain, "the plaint argument should not be null");
		Validate.notNull(algorithm, "the algorithm should not be null");
		switch(algorithm){
			case MD2 :
				return DigestUtils.md2(plain);
			case MD4 :
				return null;
			case MD5 :
				return DigestUtils.md5(plain);
			default :
				throw new NotSuchMDAlgorithm("this method don,t support the "+algorithm.getAlogithmValue()+" md algorithm");
		}
	}
	/**
	 * encrypt string data by all kinds of MD algorithm
	 * @param plaint
	 * @param algorithm
	 * @return
	 * @throws NotSuchMDAlgorithm
	 */
	public byte[] encrypt(String plaint,MDAlgorithm algorithm)throws NotSuchMDAlgorithm{
		Validate.notNull(plaint, "the plaint argument should not be null");
		byte[] bt = plaint.getBytes();
		return encrypt(bt, algorithm);
	}
	/**
	 * encrypt input stream by all kinds of MD algorithm
	 * @param input
	 * @param algorithm 
	 * @warn encrypt plain input stream isn't be closed
	 * @return
	 * @throws IOException
	 */
	public byte[] encrypt(InputStream plain,MDAlgorithm algorithm) throws IOException{
		Validate.notNull(plain, "the input argument should not be null");
		Validate.notNull(algorithm, "the algorithm should not be null");
		switch(algorithm){
			case MD2 :
				return DigestUtils.md2(plain);
			case MD4 :
				return null;
			case MD5 :
				return DigestUtils.md5(plain);
			default :
				throw new NotSuchMDAlgorithm("this method don,t support the "+algorithm.getAlogithmValue()+" md algorithm");
		}
	}
	/**
	 * byte array data transform to string .if array is null or it's length less or equal zero ,then return null.
	 * @param bt
	 * @return
	 */
	public String transform(byte[] bt){
		if(bt == null || bt.length <= 0) return null;
		return Hex.encodeHexString(bt);
	}
	
}
