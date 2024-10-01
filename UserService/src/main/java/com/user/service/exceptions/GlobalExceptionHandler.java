package com.user.service.exceptions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.user.service.modals.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@Autowired
	ApiResponse apiResponse;
	
	@ExceptionHandler(ResourcenotFoundException.class)
	public ResponseEntity<ApiResponse> handleResourceNotFoundException(ResourcenotFoundException exception) {
		String message = exception.getMessage();
		apiResponse.setMessage(message);
		apiResponse.setSuccess(false);
		apiResponse.setHttpStatus(HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(apiResponse, HttpStatus.NOT_FOUND);
	}
}
