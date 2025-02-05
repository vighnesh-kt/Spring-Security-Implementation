package com.springsecurity.controller;

import java.util.List;
import com.springsecurity.service.JWTService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springsecurity.entity.User;
import com.springsecurity.service.UserService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JWTService jwtService;

	@PostMapping("adduser")
	public User addUser(@RequestBody User user) {
		return userService.addUser(user);
	}

	@GetMapping("/admin/getusers")
	public List<User> getUser() {
		return userService.getUsers();
	}

	@PostMapping("login")
	public String login(@RequestBody User user) {
		Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword()));
		if (authentication.isAuthenticated()) {
			return jwtService.generateToken(user.getEmail());
		}
		return "Failed";
	}
	
	@GetMapping("home")
	public String getMethodName(@RequestParam String param) {
		return "Welcome home";
	}
	

}
