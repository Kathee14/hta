package com.uis.simon.hta.security;

import org.springframework.stereotype.Component;

import com.uis.simon.hta.contants.Contants;
import com.uis.simon.hta.model.JwtUser;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

@Component
public class JwtValidator {
	
	public JwtUser validate(String token) {
		JwtUser jwtUser = null;
		
		try {
			
			Claims body = Jwts.parser()
					.setSigningKey(Contants.YOUR_SECRET)
					.parseClaimsJws(token)
					.getBody();
					
			jwtUser = new JwtUser();
			jwtUser.setCc(body.getSubject());
			jwtUser.setId(Long.parseLong((String)body.get(Contants.USER_ID)));
			jwtUser.setRole((String) body.get(Contants.ROLE));	
			
		} catch(Exception e) {
			System.out.println(e);
		}  
		
		return jwtUser;
	}

}