package com.uis.simon.hta.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uis.simon.hta.dao.IUsuarioDao;
import com.uis.simon.hta.entity.Usuario;

@Service
public class UsuarioServiceImpl implements IUsuarioService{
	
	@Autowired
	private IUsuarioDao usuarioDao;
	
	@Override
	@Transactional(readOnly=true)
	public List<Usuario> findAll() {
		return (List<Usuario>) usuarioDao.findAll();
	}

	@Override
	@Transactional
	public void save(Usuario usuario) {
		usuarioDao.save(usuario);
	}

	@Override
	@Transactional(readOnly=true)
	public Usuario findUsuario(Usuario usuario) {
		return (Usuario) usuarioDao.findByUsername(usuario.getUsername());
	}

	@Override
	@Transactional(readOnly=true)
	public Usuario findByUsername(String username) {
		return usuarioDao.findByUsername(username);
	}

	@Override
	public Usuario updateUsuario(Usuario usuario) {
		return (Usuario)usuarioDao.save(usuario);
	}

	@Override
	@Transactional(readOnly=true)
	public Usuario checkUsuarioLogin(Usuario usuario) {
		return (Usuario) usuarioDao.findByUsernameAndPassword(usuario.getUsername(), usuario.getPassword());
	}

	@Override
	@Transactional
	public void deleteUsuario(Usuario usuario) {
		 usuarioDao.deleteById(usuario.getId());
	}

	@Override
	@Transactional	
	public void deleteAllUsuarios() {
		usuarioDao.deleteAll();
	}
	 
	@Override
	@Transactional
	public void deleteUsuario(Long id) {
		usuarioDao.deleteById(id);
	}
}
