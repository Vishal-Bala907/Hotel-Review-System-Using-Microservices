package com.user.service.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.service.exceptions.ResourcenotFoundException;
import com.user.service.feign.HotelService;
import com.user.service.feign.RatingService;
import com.user.service.modals.Hotel;
import com.user.service.modals.Rating;
import com.user.service.modals.User;
import com.user.service.repos.UserRepository;

@Service
public class UserServiceImple implements UserService {

	@Autowired
	private UserRepository repository;
//	@Autowired
//	private RestTemplate restTemplate;
	@Autowired
	private HotelService hotelService;
	@Autowired
	private RatingService ratingService;

	@Override
	public User saveUser(User user) {
		User save = repository.save(user);
		return save;
	}

	@Override
	public List<User> getAllUsers() {
		/*
		 * String url = "http://REVIEWSERVICE/rating/get-all"; String hotel =
		 * "http://HOTELSERVICE/hotel/get-all";
		 */
		List<User> all = repository.findAll();
		List<User> allUsersWithRatings = new ArrayList<>();

		// Use ParameterizedTypeReference to specify the correct type
		/*
		 * ResponseEntity<List<Rating>> response = restTemplate.exchange( url,
		 * HttpMethod.GET, null, new ParameterizedTypeReference<List<Rating>>() {} );
		 * List<Rating> ratings = response.getBody();
		 */
		List<Rating> ratings = ratingService.getAll().getBody();
		// Getting all the hotels
		/*
		 * ResponseEntity<List<Hotel>> hotels = restTemplate.exchange( hotel,
		 * HttpMethod.GET, null, new ParameterizedTypeReference<List<Hotel>>() {} );
		 * 
		 * List<Hotel> hotelDetails = hotels.getBody();
		 */
		List<Hotel> hotelDetails = hotelService.getAllHotel().getBody();
		// setting up ratings
		for (User u : all) {
			int id = u.getUid();
			ArrayList<Rating> collect = ratings.stream().filter(rating -> {
				return id == rating.getUserId();
			}).collect(Collectors.toCollection(ArrayList::new));
			u.setRatings(collect);
			allUsersWithRatings.add(u);
		}

		// setting up hotels
		for (Rating r : ratings) {
			String rId = r.getHotelId();
			Hotel HOTEL = hotelDetails.stream().filter(h -> {
				return h.getHotelId().equals(rId);
			}).findFirst().get();

			r.setHotel(HOTEL);

		}

		return allUsersWithRatings;
	}

	@Override
	public User getUser(int id) {
		Optional<User> byId = repository.findById(id);
		return byId.orElseThrow(() -> new ResourcenotFoundException("cannot find user"));
	}

	@Override
	public User deleteUserById(int id) {
		Optional<User> byId = repository.findById(id);
		repository.delete(byId.orElseThrow(() -> new ResourcenotFoundException("UNABLE TO DELETE USER ..." + id)));
		return byId.get();
	}

	@Override
	public User deleteUserByName(String username) {

		return null;
	}

	@Override
	public User updateUser(User user) {

		return null;
	}

}
