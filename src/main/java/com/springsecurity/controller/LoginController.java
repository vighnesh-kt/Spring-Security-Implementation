package com.springsecurity.controller;

import org.springframework.web.bind.annotation.RestController;

import com.springsecurity.entity.Student;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	List<Student> students=new ArrayList<>(List.of(
			new Student("Kaalu",10,"Java"),
			new Student("Bhaalu",23,"Bava")
			));
	
	@GetMapping("getstudents")
	public List<Student> getMethodName() {
		return students;
	}
	
	@PostMapping("addstudent")
	public List<Student> addStudent(@RequestBody Student student) {
		//TODO: process POST request
		students.add(student);
		return students;
	}
	
	@GetMapping("csrf")
	public CsrfToken getCsrfToken(HttpServletRequest req) {
		return (CsrfToken) req.getAttribute("_csrf");
	}
	
	
	
	
	

}
