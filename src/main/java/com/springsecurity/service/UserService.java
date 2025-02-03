package com.springsecurity.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.springsecurity.dao.MyUserDao;
import com.springsecurity.entity.User;

@Service
public class UserService {
	
	@Autowired
	private MyUserDao myUserDao;
	
	@Autowired
	private BCryptPasswordEncoder encoder;

	public User addUser(User user) {
		// TODO Auto-generated method stub
		user.setPassword(encoder.encode(user.getPassword()));
		return myUserDao.addUser(user);
	}

	public List<User> getUsers() {
		// TODO Auto-generated method stub
		return myUserDao.getUsers();
	}

}
