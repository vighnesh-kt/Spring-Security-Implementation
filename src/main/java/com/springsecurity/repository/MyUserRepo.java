package com.springsecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springsecurity.entity.User;
import java.util.List;




public interface MyUserRepo extends JpaRepository<User, Integer>{
	
	User findByUserName(String userName);

}
