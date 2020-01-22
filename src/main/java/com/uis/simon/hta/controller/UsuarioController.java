package com.uis.simon.hta.controller;


import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.uis.simon.hta.entity.Usuario;
import com.uis.simon.hta.model.JwtUser;
import com.uis.simon.hta.security.JwtGenerator;
import com.uis.simon.hta.service.IUsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	private IUsuarioService usuarioService;
	
	@Autowired
	private JwtGenerator jwtGenerator;

	@GetMapping("/usuarios")
	@ResponseStatus(HttpStatus.OK)
	public List<Usuario> getUsuarios(){
		return usuarioService.findAll();
	}
	
	@PostMapping("/find_usuario")
	public ResponseEntity<?> findUsuario(@RequestBody Usuario usuario){
		Usuario usuarioDb = usuarioService.findUsuario(usuario);
		if(usuarioDb!=null) {
			return new ResponseEntity<>(usuarioDb, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		}


	@PostMapping("/sign_up")
	public ResponseEntity<?> addUsuario(@RequestBody Usuario usuario){
		if(usuarioService.findUsuario(usuario)==null) {
			usuarioService.save(usuario);
			Usuario userDb = usuarioService.checkUsuarioLogin(usuario);
			JwtUser jwtUser = new JwtUser();
			jwtUser.setId(userDb.getId());
			jwtUser.setUsername(userDb.getUsername());
			return new ResponseEntity<>((Collections.singletonMap("jwtToken", jwtGenerator.generate(jwtUser))),HttpStatus.CREATED);
			
		} else {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
}
	
	@PutMapping("/update/{username}")
	public ResponseEntity<?> updateUsuario(@PathVariable(value="username")String username,@RequestBody Usuario usuario){
			Usuario usuarioDb = null;
			usuarioDb = usuarioService.findByUsername(username);
			if (usuarioDb != null) {
				usuarioDb.setEmail(usuario.getEmail());
				usuarioDb.setApellido(usuario.getApellido());
				usuarioService.updateUsuario(usuarioDb);
				return new ResponseEntity<>(usuarioDb, HttpStatus.OK);
			} else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
			}
}

	@PostMapping("/login")
	public ResponseEntity<?> loginUsuario(@RequestBody Usuario usuario){
		Usuario usuarioDb = usuarioService.checkUsuarioLogin(usuario);
		if(usuarioDb != null) {
			JwtUser jwtUser = new JwtUser();
			jwtUser.setId(usuarioDb.getId());
			jwtUser.setUsername(usuarioDb.getUsername());
			return new ResponseEntity<>((Collections.singletonMap("jwtToken", jwtGenerator.generate(jwtUser))),HttpStatus.OK);
		}else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteUsuario(@PathVariable(value="id")Long id){
		usuarioService.deleteUsuario(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}

