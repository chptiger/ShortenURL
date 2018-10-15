package com.xx.utilities;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class Utilities {
	
	public static ResponseEntity<?> getReturnMessage(String input) {
		HttpHeaders responseHeaders = new HttpHeaders();
		return new ResponseEntity<String>(input, responseHeaders, HttpStatus.CREATED);
	}
}
