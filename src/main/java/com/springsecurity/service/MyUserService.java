package com.springsecurity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.springsecurity.dao.MyUserDao;
import com.springsecurity.dao.UserPrinciple;
import com.springsecurity.entity.User;

@Service
public class MyUserService implements UserDetailsService{
	
	@Autowired
	private MyUserDao myUserDao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user=myUserDao.findByUsername(username);
		if(user==null) {
			throw new UsernameNotFoundException("Sorry not found");
		}
		return new UserPrinciple(user);
	}

	public User addUser(User user) {
		// TODO Auto-generated method stub
		return myUserDao.addUser(user);
	}
	
	

}
