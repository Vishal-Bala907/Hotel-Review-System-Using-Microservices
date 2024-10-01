package com.hotel.service.exceptions;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(RunTimeExceptionHandler.class)
	public ResponseEntity<Map<String, Object>> notFoundHandler(
			RunTimeExceptionHandler exceptionHandler) {
		
		Map<String, Object> map = new HashMap<>();
		map.put("message", exceptionHandler.getMessage());
		map.put("success", "false");
		map.put("status", HttpStatus.NOT_FOUND);
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(map);
		
		
	}
}
