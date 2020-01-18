package com.uis.simon.hta.service;

import java.util.List;

import com.uis.simon.hta.entity.Usuario;

public interface IUsuarioService {
	
	public List<Usuario> findAll();
	
	public void save(Usuario usuario);
	
	public Usuario findUsuario(Usuario usuario);
	
	public Usuario findByUsername(String username);
	
	public Usuario updateUsuario(Usuario usuario);

	public Usuario checkUsuarioLogin(Usuario usuario);
	
	public void deleteUsuario(Usuario usuario);
	
	public void deleteAllUsuarios();
	
	public void deleteUsuario(Long id);
}
