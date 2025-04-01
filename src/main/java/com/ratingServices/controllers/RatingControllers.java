package com.ratingServices.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ratingServices.Entities.Rating;
import com.ratingServices.ratingServices.RatingServices;

@RestController
@RequestMapping("/rating")
public class RatingControllers {
	
	@Autowired
	private RatingServices ratingServices;
	
	@PostMapping("/addRating")
	ResponseEntity<Rating> addRating(@RequestBody Rating rating){
		if(rating==null) {
			return ResponseEntity.badRequest().build();
		}
		else {
			return ResponseEntity.status(HttpStatus.CREATED).body(ratingServices.addrating(rating));
		}
	}

	@GetMapping("/getByUser/{userId}")
	ResponseEntity<List<Rating>>getRatingByUserID(@PathVariable String userId){
		return ResponseEntity.ok(ratingServices.ratingByUser(userId));
		
	}
}
