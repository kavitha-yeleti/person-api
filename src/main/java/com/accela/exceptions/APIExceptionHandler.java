package com.accela.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class APIExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(AddressNotFoundException.class)
	public ResponseEntity<APIError> addressNotFound(AddressNotFoundException e){
		long addressId = e.getAddressId();
		APIError error = new APIError(404,"Adress [" +addressId +"] not found");
		return new ResponseEntity<APIError>(error, HttpStatus.NOT_FOUND);
	}


	@ExceptionHandler(PersonNotFoundException.class)
	public ResponseEntity<APIError> personNotFound(PersonNotFoundException e){
		long personId = e.getPersonId();
		APIError error = new APIError(404,"Person [" +personId +"] not found");
		return new ResponseEntity<APIError>(error, HttpStatus.NOT_FOUND);
	}
}
