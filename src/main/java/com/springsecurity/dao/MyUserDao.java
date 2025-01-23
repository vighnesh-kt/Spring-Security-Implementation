package com.springsecurity.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.springsecurity.entity.User;
import com.springsecurity.repository.MyUserRepo;

public class MyUserDao {
	
	@Autowired
	private MyUserRepo userRepo;

	public User findByUserName(String string) {
		// TODO Auto-generated method stub
		return userRepo.findByUserName(string);
	}

}
