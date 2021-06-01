package com.hrworker.hruser.services;

import org.springframework.stereotype.Service;

import com.hrworker.hruser.entities.User;
import com.hrworker.hruser.repositories.UserRepository;

@Service
public class UserService {
	
	private final UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}

}
