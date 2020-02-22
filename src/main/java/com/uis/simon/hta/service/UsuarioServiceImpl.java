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
		return (Usuario) usuarioDao.findByCc(usuario.getCc());
	}

	@Override
	@Transactional(readOnly=true)
	public Usuario checkUsuarioLogin(Usuario usuario) {
		return (Usuario) usuarioDao.findByCcAndPassword(usuario.getCc(), usuario.getPassword());
	}

	@Override
	public Usuario findByCc(String cc) {
		return usuarioDao.findByCc(cc);
	}

	@Override
	public Usuario updateUsuario(Usuario usuario) {
		return (Usuario)usuarioDao.save(usuario);
	}

	@Override
	public Usuario findByRole(String role) {
		return usuarioDao.findByRole(role);
	}
	
}
