package com.uis.simon.hta.model;


import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class JwtUserDetails implements UserDetails{

private static final long serialVersionUID = 1L;
	
	private String cc;
	private Long id;
	private String token;
	private Collection <? extends GrantedAuthority> authorities;

	public JwtUserDetails(String cc, Long id, String token, List<GrantedAuthority> authorities) {
		super();
		this.cc = cc;
		this.id = id;
		this.token = token;
		this.authorities = authorities;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getCc() {
		// TODO Auto-generated method stub
		return cc;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return cc;
	}

	}


