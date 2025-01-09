package com.example.ecar.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


/**
 * Global exception handler for all controllers, handling our custom exceptions
 * and returning the proper HTTP status code with an informative message.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(AuthFailureException.class)
	public ResponseEntity<String> handleAuthFailure(AuthFailureException ex) {
		return ResponseEntity.status(401).body("Invalid credentials or token");
	}

	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<String> handleNotFound(NotFoundException ex) {
		return ResponseEntity.status(404).body("Resource not found");
	}

	@ExceptionHandler(AlreadyExistsException.class)
	public ResponseEntity<String> handleAlreadyExists(AlreadyExistsException ex) {
		return ResponseEntity.status(409).body("Account with this afm already exists");
	}

	@ExceptionHandler(BadRequestException.class)
	public ResponseEntity<String> handleBadRequest(BadRequestException ex) {
		return ResponseEntity.status(400).body(ex.getMessage());
	}
}
