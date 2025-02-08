package com.springsecurity.config;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.springsecurity.service.JWTService;
import com.springsecurity.service.MyUserDetailsService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtFilter  extends  OncePerRequestFilter{

	@Autowired
	private JWTService jwtService;
	
	@Autowired
	private MyUserDetailsService myUserDetails;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String authHeader=request.getHeader("Authorization"); //getting header from req
		System.out.println(authHeader);
		String token=null;
		String username=null;
		
		if(authHeader!=null && authHeader.startsWith("Bearer ")) { //if header is bearer and not null
			
			token=authHeader.substring(7);//getting string after bearer+' ' ie 7
			System.out.println(token);
			username=jwtService.extractUserName(token);
			System.out.println(username);
		}
		
		if(username!=null && SecurityContextHolder.getContext().getAuthentication()==null) {
			
			UserDetails userDetails=myUserDetails.loadUserByUsername(username);
			if(jwtService.validateToken(token,userDetails)) {
				UsernamePasswordAuthenticationToken authToken= new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
				authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(authToken);
			}
			
		}
		filterChain.doFilter(request, response);
		
	}

}
