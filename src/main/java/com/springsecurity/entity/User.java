package com.springsecurity.entity;

import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name="users")
public class User {
	
	private Integer id;
	private String userName;
	private String password;

}
