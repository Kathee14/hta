package com.uis.simon.hta.security;

import org.springframework.stereotype.Component;

import com.uis.simon.hta.constant.Constants;
import com.uis.simon.hta.model.JwtUser;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

@Component
public class JwtValidator {
	
	public JwtUser validate(String token) {
		JwtUser jwtUser = null;
		
		try {
			
			Claims body = Jwts.parser()
					.setSigningKey(Constants.YOUR_SECRET)
					.parseClaimsJws(token)
					.getBody();
					
			jwtUser = new JwtUser();
			jwtUser.setUsername(body.getSubject());
			jwtUser.setId(Long.parseLong((String)body.get(Constants.USER_ID)));
				
			
		} catch(Exception e) {
			System.out.println(e);
		}
		
		return jwtUser;
	}

}