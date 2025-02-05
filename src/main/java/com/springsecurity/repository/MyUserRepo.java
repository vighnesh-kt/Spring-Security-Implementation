package com.springsecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springsecurity.entity.User;



@Repository
public interface MyUserRepo extends JpaRepository<User, Integer>{
	
	User findByEmail(String email);

}
