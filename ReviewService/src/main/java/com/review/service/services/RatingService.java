package com.review.service.services;

import java.util.List;

import com.review.service.modals.Rating;

public interface RatingService {
	// create
	Rating createRating(Rating rating);
	
	// get all ratings
	List<Rating> getAllRatings();
	
	// get all ratings by user id
	List<Rating> getAllRatingByUserId(int userId);
	
	// get all ratings by hotel id
	List<Rating> getAllRatingsByHotelId(String hotelId);
	
}
