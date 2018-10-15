package com.xx.utilities;

public class ShortenURLGenerator {
	
	private static final String CHAR_MAP = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	private static final int BASE = CHAR_MAP.length();
	
	public static String idToShoretenURL(int id) {
		StringBuilder sb = new StringBuilder();
		while(id > 0) {
			sb.append(CHAR_MAP.charAt(id%BASE));
			id = id / BASE;
		}
		return sb.reverse().toString();
	}
	
	public static int shortURLtoID(String shortURL) {
		int no = 0;
		for(char c : shortURL.toCharArray()) {
			no = no * BASE + CHAR_MAP.indexOf(c);
		}
		return no;
	}
}
