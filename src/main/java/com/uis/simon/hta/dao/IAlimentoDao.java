package com.uis.simon.hta.dao;

import org.springframework.data.repository.CrudRepository;

import com.uis.simon.hta.entity.Alimento;

public interface IAlimentoDao extends CrudRepository<Alimento, Long> {
	
	
}
