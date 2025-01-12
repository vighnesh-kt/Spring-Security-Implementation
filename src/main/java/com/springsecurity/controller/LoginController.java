package com.springsecurity.controller;

import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class LoginController {
	
	@GetMapping("hello")
	public String loginCOntroller(HttpSession session) {
		return "Aur Lavde kaisa hai"+session.getId();
	}
	
	@GetMapping("about")
	public String getAbout(HttpSession session) {
		return "sbout "+session.getId();
	}
	
	

}
