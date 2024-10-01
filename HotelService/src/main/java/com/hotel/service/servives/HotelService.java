package com.hotel.service.servives;

import java.util.List;

import com.hotel.service.modals.Hotel;

public interface HotelService {
	
	Hotel createHotel(Hotel hotel);
	
	List<Hotel> getAllHotels();
	
	Hotel getHotelById(String hotelId);
}
