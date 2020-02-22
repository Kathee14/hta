package com.uis.simon.hta.dao;

import org.springframework.data.repository.CrudRepository;

import com.uis.simon.hta.entity.Usuario;

public interface IUsuarioDao extends CrudRepository<Usuario, Long> {
	
	public Usuario findByCc(String cc);
	
	public Usuario findByCcAndPassword(String cc, String password);
	
	public Usuario findByRole(String role);
	
	
}
