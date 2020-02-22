package com.uis.simon.hta.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uis.simon.hta.dao.IActividadDao;
import com.uis.simon.hta.entity.Actividad;

@Service
public class ActividadServiceImpl implements IActividadService{

	
	@Autowired
	IActividadDao actividadDao;

	@Override
	@Transactional(readOnly=true)
	public List<Actividad> findAll() {
		return (List<Actividad>) actividadDao.findAll();
		
	}
	
	
}
