package com.ratingServices.ratingRepositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ratingServices.Entities.Rating;

@Repository
public interface RatingRepositories extends JpaRepository<Rating, String> {

	Optional<List<Rating>> findByUserId(String userId);
	Optional<List<Rating>> findByHotelId(String hotelId);
	//Optional<Rating>findByUserId(String userId);

}
