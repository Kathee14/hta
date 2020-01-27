package com.uis.simon.hta.dao;

import org.springframework.data.repository.CrudRepository;

import com.uis.simon.hta.entity.Enfermero;

public interface IEnfermeroDao extends CrudRepository<Enfermero, Long>  {
	
	public Enfermero findByCc(String cc);
	
	public Enfermero findByCcAndPassword(String cc, String password);
	

}
