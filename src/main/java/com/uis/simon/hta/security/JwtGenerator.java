package com.uis.simon.hta.security;

import org.springframework.stereotype.Component;

import com.uis.simon.hta.contants.Contants;
import com.uis.simon.hta.model.JwtUser;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtGenerator {
	
public String generate(JwtUser jwtUser) {
		
		Claims claims = Jwts.claims()
				.setSubject(jwtUser.getCc());
		
		claims.put(Contants.USER_ID, String.valueOf(jwtUser.getId()));
		claims.put(Contants.ROLE, jwtUser.getRole());
		
		return Jwts.builder()
				.setClaims(claims)
				.signWith(SignatureAlgorithm.HS256, Contants.YOUR_SECRET)
				.compact();
	}

}
