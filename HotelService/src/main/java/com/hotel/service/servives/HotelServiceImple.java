package com.hotel.service.servives;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.service.exceptions.RunTimeExceptionHandler;
import com.hotel.service.modals.Hotel;
import com.hotel.service.repos.HotelRepository;

@Service
public class HotelServiceImple implements HotelService {

	@Autowired
	HotelRepository hotelRepository;
	
	@Override
	public Hotel createHotel(Hotel hotel) {
		String id = UUID.randomUUID().toString();
		hotel.setHotelId(id);
		Hotel save = hotelRepository.save(hotel);
		return save;
	}

	@Override
	public List<Hotel> getAllHotels() {
		List<Hotel> all = hotelRepository.findAll();
		return all;
	}

	@Override
	public Hotel getHotelById(String hotelId) {
		Optional<Hotel> byId = hotelRepository.findById(hotelId);
		return byId.orElseThrow(()->new RunTimeExceptionHandler("RESOURCE NOT FOUND..."));
	}

}
