package edu.autoar.base.sec;

import java.security.MessageDigest;
import java.util.Random;

public class SHA256Util {
	public static String generateSalt() {
		byte[] salt = new byte[8];
		
		Random random = new Random();
		random.nextBytes(salt);
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < salt.length; i++) {
			
			sb.append(String.format("%02x", salt[i]));
		}
		return sb.toString();
	}
	
	public static String getEncrypt(String source, String salt) {
		return getEncrypt(source, salt.getBytes());
	}
	public static String getEncrypt(String source, byte[] salt) {
		String result = "";
		
		byte[] a = source.getBytes();
		byte[] bytes = new byte[a.length + salt.length];
		
		System.arraycopy(a, 0, bytes, 0, a.length);
		System.arraycopy(salt, 0, bytes, a.length, salt.length);
		
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			md.update(bytes);
			byte[] byteData = md.digest();
			
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i < byteData.length; i++) {
				sb.append(String.format("%02x", byteData[i]));
			}
			result = sb.toString();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

}
