package com.ratingServices.Exception;

import org.springframework.http.HttpStatus;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ApiResponse {
	private String response;
	private HttpStatus status;

}
