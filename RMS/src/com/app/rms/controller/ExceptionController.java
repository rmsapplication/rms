package com.app.rms.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 
 * @author NT00477646
 *
 */
@ControllerAdvice
public class ExceptionController {
	
	/**
	 * 
	 * @param exception
	 * @return
	 */
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleException(Exception exception){
		return new ResponseEntity<String>(exception.getMessage(),HttpStatus.SERVICE_UNAVAILABLE);
	}
}
