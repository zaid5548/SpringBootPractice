package com.khan.org.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class UserDataAccessException extends Exception {

	private static final long serialVersionUID = 1L;

	public UserDataAccessException(String errorMessage) {
		super(errorMessage);
	}		
}
