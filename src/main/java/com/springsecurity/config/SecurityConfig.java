package com.springsecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;

@EnableMethodSecurity
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	public SecurityFilterChain sfc(HttpSecurity sec) throws Exception {
		
		sec.authorizeHttpRequests(req->req.anyRequest().authenticated());
		sec.csrf(csrf->csrf.disable());
		//sec.formLogin(Customizer.withDefaults());
		sec.httpBasic(Customizer.withDefaults());
		sec.sessionManagement(ses->ses.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
		return sec.build();
	}
	
	@Bean
	public UserDetailsService usc() {
		
		UserDetails user1=User.withDefaultPasswordEncoder()
				.username("Rakoz")
				.password("R123")
				.roles("USER")
				.build();
		
		UserDetails user2=User.withDefaultPasswordEncoder()
				.username("Jakoz")
				.password("J123")
				.roles("ADMIN")
				.build();
		
		return new InMemoryUserDetailsManager(user1,user2);
	}
}
