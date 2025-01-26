package com.springsecurity.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
@Table(name = "my_user")
public class User {
	
	@Id
	private Integer id;
	private String username;
	private String password;
	private String role;

}
