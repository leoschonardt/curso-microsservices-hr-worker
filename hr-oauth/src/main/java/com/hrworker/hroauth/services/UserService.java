package com.hrworker.hroauth.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.hrworker.hroauth.entities.User;
import com.hrworker.hroauth.feignClients.UserFeignClient;

@Service
public class UserService implements UserDetailsService {
	
	private static Logger log = LoggerFactory.getLogger(UserService.class);
	private final UserFeignClient userFeignClient;

	public UserService(UserFeignClient userFeignClient) {
		this.userFeignClient = userFeignClient;
	}
	
	public User findByEmail(String email) {
		User user = userFeignClient.findByEmail(email).getBody();
		if (user != null) {
			log.debug(user.toString());
			return user;
		}
		log.debug("Not found");
		throw new RuntimeException("User not found");
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		log.info("user = " + username);
		try {
			return findByEmail(username);
		} catch (Exception e) {
			log.info(e.getMessage());
			throw new UsernameNotFoundException(e.getMessage());
		}
	}
	
	
	
}
