package com.uis.simon.hta.model;

import java.util.Date;

import com.uis.simon.hta.entity.Usuario;

public class MUsuario {
	 
	private Long id;
	private String nombre;
	private String apellido;
	private String username;
	private String tipo_doc;
	private String n_doc;
	private Date fec_nac;
	private String ciudad;
	private String direccion;
	private String barrio;
	private String sexo;	
	private String email;
	private Long celular;
	
	public MUsuario() {
		
	}
	
	public MUsuario(Long id, String nombre, String apellido, String username, String tipo_doc, String n_doc,
			Date fec_nac, String ciudad, String direccion, String barrio, String password, String sexo, String email,
			Long celular) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.username = username;
		this.tipo_doc = tipo_doc;
		this.n_doc = n_doc;
		this.fec_nac = fec_nac;
		this.ciudad = ciudad;
		this.direccion = direccion;
		this.barrio = barrio;
		this.sexo = sexo;
		this.email = email;
		this.celular = celular;
	}
	
	public MUsuario(Usuario usuario) {
		this.id = usuario.getId();
		this.nombre = usuario.getNombre();
		this.apellido = usuario.getApellido();
		this.username = usuario.getUsername();
		this.tipo_doc = usuario.getTipo_doc();
		this.n_doc = usuario.getN_doc();
		this.fec_nac = usuario.getFec_nac();
		this.ciudad = usuario.getCiudad();
		this.direccion = usuario.getDireccion();
		this.barrio = usuario.getBarrio();
		this.sexo = usuario.getSexo();
		this.email = usuario.getEmail();
		this.celular = usuario.getCelular();
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getTipo_doc() {
		return tipo_doc;
	}
	public void setTipo_doc(String tipo_doc) {
		this.tipo_doc = tipo_doc;
	}
	public String getN_doc() {
		return n_doc;
	}
	public void setN_doc(String n_doc) {
		this.n_doc = n_doc;
	}
	public Date getFec_nac() {
		return fec_nac;
	}
	public void setFec_nac(Date fec_nac) {
		this.fec_nac = fec_nac;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getBarrio() {
		return barrio;
	}
	public void setBarrio(String barrio) {
		this.barrio = barrio;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getCelular() {
		return celular;
	}
	public void setCelular(Long celular) {
		this.celular = celular;
	}	
}
