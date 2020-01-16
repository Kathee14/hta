package com.uis.simon.hta.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	
	@GetMapping("/prueba")
	public ResponseEntity<String> prueba(){	
		return new ResponseEntity<String> ("PRUEBA", HttpStatus.OK);
	}
}
