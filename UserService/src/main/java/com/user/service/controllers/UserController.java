package com.user.service.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.service.modals.User;
import com.user.service.services.UserServiceImple;

import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserServiceImple userServiceImple;
	private final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

	@PostMapping("/create")
	public ResponseEntity<User> createUser(@RequestBody User user) {
		User saveUser = userServiceImple.saveUser(user);
		return new ResponseEntity<User>(saveUser, HttpStatus.CREATED);
	}

	@GetMapping("/get/{id}")
//	@CircuitBreaker(name = "ratingHotelBreaker", fallbackMethod = "ratingHotelFallback")
//	@Retry(name = "ratingHotelRetry", fallbackMethod = "ratingHotelFallback")
	@RateLimiter(name="userRateLimiter",fallbackMethod = "ratingHotelFallback")
	public ResponseEntity<User> getUser(@PathVariable("id") int id) {
		LOGGER.error("RETRY");
		User user = userServiceImple.getUser(id);
		return new ResponseEntity<User>(user, HttpStatus.CREATED);
	}

	public ResponseEntity<User> ratingHotelFallback(int id, Exception exception) {
		LOGGER.info("Fall back is executed ....\n Service is down " + exception.getMessage());

		return new ResponseEntity<User>(new User(), HttpStatus.BAD_REQUEST);
	}

	@GetMapping("/get-all")
	public ResponseEntity<List<User>> getAllUsers() {
		List<User> users = userServiceImple.getAllUsers();
		return new ResponseEntity<List<User>>(users, HttpStatus.CREATED);
	}

}
