package com.javanotes.example.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SuppressWarnings("serial")
public class JavaNotesException extends RuntimeException {

	@SuppressWarnings("rawtypes")
	public ResponseEntity responseEntity;

	public JavaNotesException(HttpStatus status, Object message) {
		this.responseEntity= new ResponseEntity<>( message,status);
	}

	public JavaNotesException(HttpStatus status) {
        this.responseEntity = new ResponseEntity<>( status);
	}

}
