package com.user.service.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.service.exceptions.ResourcenotFoundException;
import com.user.service.modals.User;
import com.user.service.repos.UserRepository;

@Service
public class UserServiceImple implements UserService {

	@Autowired
	private UserRepository repository;

	@Override
	public User saveUser(User user) {
		User save = repository.save(user);
		return save;
	}

	@Override
	public List<User> getAllUsers() {
		return repository.findAll();
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
