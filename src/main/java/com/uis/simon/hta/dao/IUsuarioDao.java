package com.uis.simon.hta.dao;

import org.springframework.data.repository.CrudRepository;

import com.uis.simon.hta.entity.Usuario;

public interface IUsuarioDao extends CrudRepository<Usuario, Long> {
	
	public Usuario findByUsername(String username);
	
	public Usuario findByUsernameAndPassword(String email, String password);


}
