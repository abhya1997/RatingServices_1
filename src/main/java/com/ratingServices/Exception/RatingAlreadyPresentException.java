package com.ratingServices.Exception;

public class RatingAlreadyPresentException extends RuntimeException {
	public RatingAlreadyPresentException() {
		
		super();
	}

	
	public RatingAlreadyPresentException(String msg) {
		
		super(msg);
	}
}
