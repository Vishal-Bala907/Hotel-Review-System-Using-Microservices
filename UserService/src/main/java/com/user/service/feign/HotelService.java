package com.user.service.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.user.service.modals.Hotel;

@Component
@FeignClient("HOTELSERVICE")
public interface HotelService {
	// create
	@PostMapping("/hotel/create")
	public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel);

	// get hotel
	@GetMapping("/hotel/get/{id}")
	public ResponseEntity<Hotel> getHotel(@PathVariable("id") String id);

	// get all
	@GetMapping("/hotel/get-all")
	public ResponseEntity<List<Hotel>> getAllHotel();
}
