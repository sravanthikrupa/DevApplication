package com.app.dca.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler
	public ResponseEntity<MyExceptionResponse> invalidDeveloperId(UnknownDeveloperException ex)
	{
		
		
		// design custom exception response 
		
		MyExceptionResponse excResponse = new MyExceptionResponse();
		excResponse.setHttpStatus(HttpStatus.BAD_REQUEST.value());
		excResponse.setExceptionMsg("Invalid developer Id pls try again");
		
		
		return new ResponseEntity<MyExceptionResponse>(excResponse,HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler
	public ResponseEntity<MyExceptionResponse> invalidFeedId(UnknownFeedException ex)
	{
		int feedId = ex.getId();
		
		// design custom exception response 
		
		MyExceptionResponse excResponse = new MyExceptionResponse();
		excResponse.setHttpStatus(HttpStatus.BAD_REQUEST.value());
		excResponse.setExceptionMsg("Invalid Feed Id "+feedId+" pls try again");
		
		
		return new ResponseEntity<MyExceptionResponse>(excResponse,HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler
	public ResponseEntity<MyExceptionResponse> invalidFeedResponseId(UnknownFeedResponseException ex)
	{
		
		
		// design custom exception response 
		
		MyExceptionResponse excResponse = new MyExceptionResponse();
		excResponse.setHttpStatus(HttpStatus.BAD_REQUEST.value());
		excResponse.setExceptionMsg("Invalid Feed response Id pls try again");
		
		
		return new ResponseEntity<MyExceptionResponse>(excResponse,HttpStatus.BAD_REQUEST);
		
	}
	
}
