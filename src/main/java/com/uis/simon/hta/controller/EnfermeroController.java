package com.uis.simon.hta.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.uis.simon.hta.entity.Enfermero;
import com.uis.simon.hta.model.JwtUser;
import com.uis.simon.hta.security.JwtGenerator;
import com.uis.simon.hta.service.IEnfermeroService;


@CrossOrigin
@RestController
@RequestMapping("/enfermero")
public class EnfermeroController {
	
	@Autowired
	private IEnfermeroService enfermeroService;
	
	@Autowired
	private JwtGenerator jwtGenerator;
	
	@GetMapping("/lista")
	@ResponseStatus(HttpStatus.OK)
	public List<Enfermero> getEnfermeros(){
		return enfermeroService.findAll();
	}
	
	@PostMapping("/find_enfermero")
	public ResponseEntity<?> findEnfermero(@RequestBody Enfermero enfermero){
	Enfermero enfermeroDb = enfermeroService.findEnfermero(enfermero);
	if (enfermeroDb!=null) {
		return new ResponseEntity<> (enfermeroDb, HttpStatus.OK);
	} else {
		
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}
	
	@PostMapping("/login")
	public ResponseEntity<?> loginEnfermero(@RequestBody Enfermero enfermero){
		Enfermero enfermeroDb = enfermeroService.checkUsuarioLogin(enfermero);
		if(enfermeroDb != null) {
			JwtUser jwtUser = new JwtUser();
			jwtUser.setId(enfermeroDb.getId());
			jwtUser.setCc(enfermeroDb.getCc());
			return new ResponseEntity<>((Collections.singletonMap("jwtToken", jwtGenerator.generate(jwtUser))),HttpStatus.OK);
		}else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}
	

}
