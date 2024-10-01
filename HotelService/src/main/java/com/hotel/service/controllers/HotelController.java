package com.hotel.service.controllers;

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

import com.hotel.service.modals.Hotel;
import com.hotel.service.servives.HotelServiceImple;

@RestController
@RequestMapping("/hotel")
public class HotelController {
	@Autowired
	private HotelServiceImple hotelService;

	// create
	@PostMapping("/create")
	public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel) {
		return new ResponseEntity<Hotel>(hotelService.createHotel(hotel), HttpStatus.CREATED);

	}

	// get hotel
	@GetMapping("/get/{id}")
	public ResponseEntity<Hotel> getHotel(@PathVariable("id") String id) {
		return new ResponseEntity<Hotel>(hotelService.getHotelById(id), HttpStatus.OK);

	}

	// get all
	@GetMapping("/get-all")
	public ResponseEntity<List<Hotel>> getAllHotel() {
		return new ResponseEntity<List<Hotel>>(hotelService.getAllHotels(), HttpStatus.OK);

	}
}
