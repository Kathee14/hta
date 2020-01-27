package com.uis.simon.hta.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uis.simon.hta.dao.IEnfermeroDao;
import com.uis.simon.hta.entity.Enfermero;

@Service
public class EnfermeroServiceImpl implements IEnfermeroService {
	
	@Autowired
	private IEnfermeroDao enfermeroDao;

	@Override
	@Transactional(readOnly=true)
	public List<Enfermero> findAll() {
	return (List<Enfermero>) enfermeroDao.findAll();
		
	}

	@Override
	@Transactional(readOnly=true)
	public Enfermero findEnfermero(Enfermero enfermero) {
		return (Enfermero)enfermeroDao.findByCc(enfermero.getCc());
	}

	@Override
	public Enfermero findByCc(String cc) {
		return enfermeroDao.findByCc(cc);
	}

	@Override
	public Enfermero checkUsuarioLogin(Enfermero enfermero) {
		return (Enfermero) enfermeroDao.findByCcAndPassword(enfermero.getCc(), enfermero.getPassword());
	}
	
}
