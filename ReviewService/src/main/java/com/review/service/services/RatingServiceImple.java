package com.review.service.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.review.service.modals.Rating;
import com.review.service.repos.RatingRepository;

@Service
public class RatingServiceImple implements RatingService {
	@Autowired
	private RatingRepository ratingRepository;

	@Override
	public Rating createRating(Rating rating) {
		String id = UUID.randomUUID().toString();
		rating.setRatingId(id);
		Rating save = ratingRepository.save(rating);
		return save;
	}

	@Override
	public List<Rating> getAllRatings() {
		List<Rating> all = ratingRepository.findAll();
		return all;
	}

	@Override
	public List<Rating> getAllRatingByUserId(int userId) {
		List<Rating> byUserId = ratingRepository.findByUserId(userId);
		return byUserId;
	}

	@Override
	public List<Rating> getAllRatingsByHotelId(String hotelId) {
		List<Rating> byHotelId = ratingRepository.findByHotelId(hotelId);
		return byHotelId;
	}

}
