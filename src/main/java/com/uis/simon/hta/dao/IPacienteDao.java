package com.uis.simon.hta.dao;

import org.springframework.data.repository.CrudRepository;

import com.uis.simon.hta.entity.Paciente;;

public interface IPacienteDao extends CrudRepository<Paciente, Long> {
	
	public Paciente findByCc(String cc);
	
	public Paciente findByCcAndPassword(String cc, String password);
	
	}
