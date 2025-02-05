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
public class MyUserDetailsService implements UserDetailsService{
	
	@Autowired
	private MyUserDao myUserDao;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user=myUserDao.findByEmail(email);
		if(user==null) {
			System.out.println("Galat mat daal");
			throw new UsernameNotFoundException("Sorry not found");
		}
		return new UserPrinciple(user);
	}	

}
