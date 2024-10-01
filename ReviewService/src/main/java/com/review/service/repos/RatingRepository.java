package com.review.service.repos;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.review.service.modals.Rating;

@Repository
public interface RatingRepository extends MongoRepository<Rating, String> {
	
	List<Rating> findByHotelId(String hotelId);
	
	List<Rating> findByUserId(int id);
	
}
