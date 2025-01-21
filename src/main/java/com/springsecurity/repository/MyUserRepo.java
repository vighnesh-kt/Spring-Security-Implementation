package com.springsecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springsecurity.entity.User;



public interface MyUserRepo extends JpaRepository<User, Integer>{

}
