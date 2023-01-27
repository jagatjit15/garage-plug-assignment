package com.garageplug.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(UserCreationException.class)
	public ResponseEntity<ResponseError> UserCreationExceptionHandler(UserCreationException 
			                                             exception, WebRequest request){
		
		ResponseError error = new ResponseError();
		
		error.setTimeStamp(LocalDateTime.now());
		error.setMessage(exception.getMessage());
		error.setDetails(request.getDescription(false));
		
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
		
	}

	
	@ExceptionHandler(OrderException.class)
	public ResponseEntity<ResponseError> OrderExceptionHandler(OrderException 
			                                             exception, WebRequest request){
		
		ResponseError error = new ResponseError();
		
		error.setTimeStamp(LocalDateTime.now());
		error.setMessage(exception.getMessage());
		error.setDetails(request.getDescription(false));
		
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
		
	}
	
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ResponseError> methodValidationExceptionHandler(MethodArgumentNotValidException exception){
		

		ResponseError error = new ResponseError();// for sending user understandable format of exceptions and errors
		
		error.setTimeStamp(LocalDateTime.now()); // current time when exception happen
		
		error.setMessage(exception.getBindingResult().getFieldError().getDefaultMessage()); // Exception error 
		
		error.setDetails("validation fails"); // returns URI of URL for which error comes.
		
		
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
		
	}
	
//	Handler or Invalid URI exceptions
	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<ResponseError> nohandlerFoundhandler(NoHandlerFoundException exception, WebRequest request){
		

		ResponseError error = new ResponseError();// for sending user understandable format of exceptions and errors
		
		error.setTimeStamp(LocalDateTime.now()); // current time when exception happen
		
		error.setMessage(exception.getMessage()); // Exception error 
		
		error.setDetails(request.getDescription(false)); // returns URI of URL for which error comes.
		
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
		
	}
	
	
	
	
}
