package com.hrworker.hruser.resources;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hrworker.hruser.entities.User;
import com.hrworker.hruser.services.UserService;


@RefreshScope
@RestController
@RequestMapping(value = "/users")
public class UserResource {

	private static Logger log = LoggerFactory.getLogger(UserResource.class);
	private final UserService userService;

	public UserResource(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping(value = "/search")
	public ResponseEntity<User> findByEmail(@RequestParam(value = "email") String email) {
		return ResponseEntity.ok(userService.findByEmail(email));
	}
	
}
