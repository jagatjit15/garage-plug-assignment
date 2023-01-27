package com.garageplug.exceptions;

public class UserCreationException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public UserCreationException() {
		
	}
	
	public UserCreationException(String message) {
		
		super(message);
		
	}
	

}
