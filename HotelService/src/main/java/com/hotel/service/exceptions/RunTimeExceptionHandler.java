package com.hotel.service.exceptions;

public class RunTimeExceptionHandler extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public RunTimeExceptionHandler() {
		super("Something got wrong");
	}
	
	public RunTimeExceptionHandler(String message) {
		super(message);
	}

}
