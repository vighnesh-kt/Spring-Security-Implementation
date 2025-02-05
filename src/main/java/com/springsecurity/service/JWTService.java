package com.springsecurity.service;

import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JWTService {
	
	private String secretKey;
	
	public JWTService(){
		secretKey=generateKey();
	}
	
	public String generateToken(String username) {
		Map<String, Object> claims= new HashMap<>();
		return Jwts.builder()
		.setClaims(claims)
		.subject(username)
		.setIssuedAt(new Date(System.currentTimeMillis()))
		.setExpiration(new Date(System.currentTimeMillis()*30*60*1000))
		.signWith(getKey(), SignatureAlgorithm.HS256).compact();
		
	}
	
	private String generateKey() {
		try {
			KeyGenerator keyGen= KeyGenerator.getInstance("HmacSHA256");
			SecretKey secretKey =keyGen.generateKey();
			System.out.println(secretKey.toString());
			return Base64.getEncoder().encodeToString(secretKey.getEncoded());
			
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	private Key getKey() {
		byte[] keyBytes=Decoders.BASE64.decode(secretKey);
		return Keys.hmacShaKeyFor(keyBytes);
	}

}
