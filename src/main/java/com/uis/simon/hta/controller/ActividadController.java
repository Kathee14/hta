package com.uis.simon.hta.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uis.simon.hta.entity.Actividad;
import com.uis.simon.hta.service.IActividadService;

@RestController
@RequestMapping("/user/actividad")
public class ActividadController {
	
	@Autowired
	IActividadService actividadService;
	
	@GetMapping("/lista")
    public ResponseEntity<List<Actividad>> getLista(){
        List<Actividad> lista = actividadService.findAll();
        return new ResponseEntity<List<Actividad>>(lista, HttpStatus.OK);
    }


}
