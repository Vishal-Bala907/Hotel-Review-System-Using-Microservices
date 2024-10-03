package com.user.service.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.user.service.modals.Rating;


@Component
@FeignClient(name="REVIEWSERVICE")
public interface RatingService {
	// create
		@PostMapping("/rating/create")
		public ResponseEntity<Rating> createRating(@RequestBody Rating rating);

		// get all
		@GetMapping("/rating/get-all")
		public ResponseEntity<List<Rating>> getAll();

		// get all
		@GetMapping("/rating/get-user-rating/{userId}")
		public ResponseEntity<List<Rating>> getRatingsByUserId(@PathVariable int userId);

		// get all
		@GetMapping("/rating/get-hotel-rating/{hotelId}")
		public ResponseEntity<List<Rating>> getRatingsByHotelId(@PathVariable String hotelId);
}
