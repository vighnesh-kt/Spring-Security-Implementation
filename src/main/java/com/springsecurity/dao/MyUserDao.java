package com.springsecurity.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springsecurity.entity.User;
import com.springsecurity.repository.MyUserRepo;

@Service
public class MyUserDao {
	
	@Autowired
	private MyUserRepo userRepo;

	public User findByUsername(String string) {
		// TODO Auto-generated method stub
		return userRepo.findByUsername(string);
	}

	public User addUser(User user) {
		// TODO Auto-generated method stub
		return userRepo.save(user);
	}

}
