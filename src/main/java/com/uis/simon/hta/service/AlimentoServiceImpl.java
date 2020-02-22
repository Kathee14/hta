package com.uis.simon.hta.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uis.simon.hta.dao.IAlimentoDao;
import com.uis.simon.hta.entity.Alimento;

@Service
public class AlimentoServiceImpl implements IAlimentoService{

	
	@Autowired
	private IAlimentoDao alimentoDao;
	
	@Override
	@Transactional(readOnly=true)
	public List<Alimento> findAll() {
		return (List<Alimento>) alimentoDao.findAll();	
	}

	}
