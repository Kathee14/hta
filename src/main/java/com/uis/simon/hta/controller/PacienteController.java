package com.uis.simon.hta.controller;


import java.util.Collections;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.uis.simon.hta.dto.NuevoPaciente;
import com.uis.simon.hta.entity.Paciente;
import com.uis.simon.hta.model.JwtUser;
import com.uis.simon.hta.security.JwtGenerator;
import com.uis.simon.hta.service.IPacienteService;

@CrossOrigin
@RestController
@RequestMapping("/paciente")
public class PacienteController {
	
	@Autowired
	private IPacienteService pacienteService;
	
    @Autowired
    PasswordEncoder passwordEncoder;
	
	@Autowired
	private JwtGenerator jwtGenerator;

	@GetMapping("/listau")
	@ResponseStatus(HttpStatus.OK)
	public List<Paciente> getUsuarios(){
		return pacienteService.findAll();
	}
	
	@PostMapping("/find_usuario")
	public ResponseEntity<?> findUsuario(@RequestBody Paciente paciente){
		Paciente pacienteDb = pacienteService.findUsuario(paciente);
		if(pacienteDb!=null) {
			return new ResponseEntity<>(pacienteDb, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		}


	@PostMapping("/registrar")
	public ResponseEntity<?> addUsuario(@Valid @RequestBody NuevoPaciente nuevoPaciente,BindingResult bindingResult){
		if(bindingResult.hasErrors())
            return new ResponseEntity<String>("Campos vacíos o email invalido", HttpStatus.BAD_REQUEST);
		Paciente paciente = new Paciente(nuevoPaciente.getNombre(),nuevoPaciente.getApellido(), nuevoPaciente.getTipo_doc(),
								nuevoPaciente.getCc(),nuevoPaciente.getFec_nac(), nuevoPaciente.getCiudad(),nuevoPaciente.getDireccion(),
								nuevoPaciente.getBarrio(),passwordEncoder.encode(nuevoPaciente.getPassword()),nuevoPaciente.getSexo(),
										nuevoPaciente.getEmail(),nuevoPaciente.getCelular());
		if(pacienteService.findUsuario(paciente) == null) {
			pacienteService.save(paciente);
			Paciente pacienteDb = pacienteService.checkUsuarioLogin(paciente);
			JwtUser jwtUser = new JwtUser();
			jwtUser.setCc(pacienteDb.getCc());
			jwtUser.setPassword(pacienteDb.getPassword());
			return new ResponseEntity<>((Collections.singletonMap("jwtToken", jwtGenerator.generate(jwtUser))),HttpStatus.CREATED);
			
		} else {
			
			return new ResponseEntity<String>("El usuario con ese documento ya existe", HttpStatus.CONFLICT);
		}
}
	
	@PutMapping("/update/{cc}")
	public ResponseEntity<?> updateUsuario(@PathVariable(value="cc")String cc,@RequestBody Paciente paciente){
		Paciente pacienteDb = null;
		pacienteDb = pacienteService.findByCc(cc);
			if (pacienteDb != null) {
				pacienteDb.setEmail(paciente.getEmail());
				pacienteDb.setApellido(paciente.getApellido());
				pacienteService.updateUsuario(pacienteDb);
				return new ResponseEntity<>(pacienteDb, HttpStatus.OK);
			} else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
			}
}

	@PostMapping("/login")
	public ResponseEntity<?> loginPaciente(@RequestBody Paciente paciente){
		Paciente pacienteDb = pacienteService.checkUsuarioLogin(paciente);
		if(pacienteDb != null) {
			JwtUser jwtUser = new JwtUser();
			jwtUser.setCc(pacienteDb.getCc());
			jwtUser.setPassword(pacienteDb.getPassword());
			return new ResponseEntity<>((Collections.singletonMap("jwtToken", jwtGenerator.generate(jwtUser))),HttpStatus.OK);
		} else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}
	
}
    
    