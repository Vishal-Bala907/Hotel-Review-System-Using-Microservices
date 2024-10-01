package com.user.service.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.user.service.modals.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
