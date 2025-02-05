package com.springsecurity.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springsecurity.entity.User;
import com.springsecurity.repository.MyUserRepo;

@Service
public class MyUserDao {
	
	@Autowired
	private MyUserRepo myUserRepo;

	public User findByEmail(String email) {
		// TODO Auto-generated method stub
		return myUserRepo.findByEmail(email);
	}

	public User addUser(User user) {
		// TODO Auto-generated method stub
		return myUserRepo.save(user);
	}

	public List<User> getUsers() {
		// TODO Auto-generated method stub
		return myUserRepo.findAll();
	}

}
