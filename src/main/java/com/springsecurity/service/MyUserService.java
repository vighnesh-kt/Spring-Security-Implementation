package com.springsecurity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.springsecurity.dao.MyUserDao;
import com.springsecurity.entity.User;

public class MyUserService implements UserDetailsService{
	
	@Autowired
	private MyUserDao myUserDao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user=myUserDao.findByUserName("Rakoz");
		return null;
	}
	
	

}
