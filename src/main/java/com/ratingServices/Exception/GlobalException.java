package com.ratingServices.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {

	@ExceptionHandler(HotelNotFondException.class)
	public ResponseEntity<ApiResponse> hotelNotFoundException( HotelNotFondException exception){
		String str=exception.getMessage();
		ApiResponse apiResponse=ApiResponse.builder().response(str).status(HttpStatus.NOT_FOUND).build();
		
		return new ResponseEntity<>(apiResponse,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(RatingAlreadyPresentException.class)
	public ResponseEntity<ApiResponse> ratingalreadyPresentException(RatingAlreadyPresentException exception){
		
		String str=exception.getMessage();
		ApiResponse apiResponse=ApiResponse.builder().response(str).status(HttpStatus.NOT_FOUND).build();
		
		return new ResponseEntity<>(apiResponse,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<ApiResponse> UserNotFoundException(UserNotFoundException exception){
		
		String str=exception.getMessage();
		ApiResponse apiResponse=ApiResponse.builder().response(str).status(HttpStatus.NOT_FOUND).build();
		
		return new ResponseEntity<>(apiResponse,HttpStatus.NOT_FOUND);
	}
	
	
}
