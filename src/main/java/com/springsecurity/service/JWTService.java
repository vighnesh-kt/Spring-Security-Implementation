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
//		.setClaims(claims)
//		.subject(username)
//		.setIssuedAt(new Date(System.currentTimeMillis()))
//		.setExpiration(new Date(System.currentTimeMillis()+ 1000*60*30))
//		.signWith(getKey(), SignatureAlgorithm.HS256).compact();
		  .claims(claims) // Or add claims directly here, e.g., .claim("key", "value")
	        .subject(username)
	        .issuedAt(new Date(System.currentTimeMillis()))
	        .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 30)) // 30 minutes
	        .signWith(getKey()) // Ensure getKey() returns a SecretKey
	        .compact();
		
	}
	
	private String generateKey() {
		try {
			KeyGenerator keyGen= KeyGenerator.getInstance("HmacSHA256");
			SecretKey secretKey =keyGen.generateKey();
			// Print the raw byte array of the secret key
            byte[] encodedKey = secretKey.getEncoded();
            System.out.println("Secret Key (Byte Array): " + encodedKey);

            // Optionally, you can encode it to Base64 to make it human-readable
            String base64EncodedKey = Base64.getEncoder().encodeToString(encodedKey);
            System.out.println("Secret Key (Base64 Encoded): " + base64EncodedKey);
			return Base64.getEncoder().encodeToString(secretKey.getEncoded());//directly converting 
			
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
