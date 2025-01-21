package com.springsecurity.dao;

import org.springframework.beans.factory.annotation.Autowired;

import com.springsecurity.repository.MyUserRepo;

public class MyUserDao {
	
	@Autowired
	private MyUserRepo userRepo;

}
