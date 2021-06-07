package com.hrworker.hroauth.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hrworker.hroauth.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	private final UserService service;

	public UserResource(UserService service) {
		this.service = service;
	}
	
	@GetMapping(value = "/search")
	public ResponseEntity<UserDetails> getByEmail(@RequestParam(name = "email") String email) {
		return ResponseEntity.ok(service.loadUserByUsername(email));
	}
	
}
