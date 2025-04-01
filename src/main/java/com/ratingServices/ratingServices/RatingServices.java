package com.ratingServices.ratingServices;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

//import com.ratingServices.Entities.Hotel;
import com.ratingServices.Entities.Rating;
import com.ratingServices.Exception.HotelNotFondException;
import com.ratingServices.Exception.RatingAlreadyPresentException;
import com.ratingServices.Exception.UserNotFoundException;
import com.ratingServices.ratingRepositories.RatingRepositories;

@Service
public class RatingServices {
	
	@Autowired
	private RatingRepositories ratingRepositories;
	
	@Autowired
	private RestTemplate restTemplate;
	
	
	public Rating addrating(Rating rating) {		
	    Optional<List<Rating>> existingRatings = ratingRepositories.findByUserId(rating.getUserId());
	    
	    if (existingRatings.isEmpty()) {  // Check if the list is not empty
	        throw new RatingAlreadyPresentException("Rating already exists for this user.");
	    }

	    String str = UUID.randomUUID().toString();
	    rating.setRate_id(str);
	    return ratingRepositories.save(rating);
	}
	
	public List<Rating> ratingByUser(String userId) {
		Optional<List<Rating>> rating=ratingRepositories.findByUserId(userId);
		
		if(rating.isPresent()) {
			
			List<Rating>ratings=rating.get();
			//List<Rating>rating_1= rating.stream().map(rating->{
			  //ResponseEntity<Hotel>bo=	restTemplate.getForEntity("http://localhost:8082/hotel/123", Hotel.class);
			  //Hotel hotel=bo.getBody();
			//}).toList();
			
			
			return rating.get();
		}
		else {
			throw new UserNotFoundException("This user is not in System");
		}
		
		
	}
	
	public List<Rating> ratingByHotel(String hotel_id) {
	Optional<List<Rating>>rating=	ratingRepositories.findByHotelId(hotel_id);
	
		if(rating.isPresent()) {
			return rating.get();
		}
		else {
			throw new HotelNotFondException("Hotel not Found");
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
