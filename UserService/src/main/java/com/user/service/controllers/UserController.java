package com.user.service.controllers;

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

import com.user.service.modals.User;
import com.user.service.services.UserServiceImple;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserServiceImple userServiceImple;
	
	@PostMapping("/create")
	public ResponseEntity<User> createUser(@RequestBody User user) {
		User saveUser = userServiceImple.saveUser(user);
		return new ResponseEntity<User>(saveUser, HttpStatus.CREATED);
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<User> getUser(@PathVariable("id") int id) {
		User user = userServiceImple.getUser(id);
		return new ResponseEntity<User>(user, HttpStatus.CREATED);
	}
	
	@GetMapping("/get-all")
	public ResponseEntity<List<User>> getAllUsers() {
		List<User> users = userServiceImple.getAllUsers();
		return new ResponseEntity<List<User>>(users, HttpStatus.CREATED);
	}
	
	

}
