package com.user.service.services;

import java.util.List;

import com.user.service.modals.User;


public interface UserService {
	
	User saveUser(User user);
	
	List<User> getAllUsers();
	
	User getUser(int id);
	
	User deleteUserById(int id);
	
	User deleteUserByName(String username);
	
	User updateUser(User user);
	
}
