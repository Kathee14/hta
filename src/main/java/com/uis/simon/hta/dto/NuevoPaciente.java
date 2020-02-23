package com.uis.simon.hta.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class NuevoPaciente {
	
	@NotBlank
	@Column(name="nombre")
	private String nombre;
	
	@NotBlank
	@Column(name="apellido")
	private String apellido;
	
	@NotBlank
	@Column(name="tipo_doc")
	private String tipo_doc;
	
	@NotBlank
	@Column(name="cc", unique=true)
	private String cc;
	
	@NotNull
	@Column(name="fec_nac")
	private Date fec_nac;
	
	@NotBlank
	@Column(name="ciudad")
	private String ciudad;
	
	@NotBlank
	@Column(name="direccion")
	private String direccion;
	
	@NotBlank
	@Column(name="barrio")
	private String barrio;
	
	@NotBlank
	@Column(name="password")
	private String password;
	
	@Column(name="sexo")
	private String sexo;
	
	@NotBlank
	@Email
	@Column(length=60)
	private String email;
	
	@NotNull
	@Column(name="celular")
	private Long celular;
	

	 public NuevoPaciente(){}

	public NuevoPaciente(@NotBlank String nombre, @NotBlank String apellido, @NotBlank String tipo_doc,
			@NotBlank String cc, @NotNull Date fec_nac, @NotBlank String ciudad, @NotBlank String direccion,
			@NotBlank String barrio, @NotBlank String password, String sexo, @NotBlank @Email String email,
			@NotNull Long celular) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.tipo_doc = tipo_doc;
		this.cc = cc;
		this.fec_nac = fec_nac;
		this.ciudad = ciudad;
		this.direccion = direccion;
		this.barrio = barrio;
		this.password = password;
		this.sexo = sexo;
		this.email = email;
		this.celular = celular;
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

	public String getTipo_doc() {
		return tipo_doc;
	}

	public void setTipo_doc(String tipo_doc) {
		this.tipo_doc = tipo_doc;
	}

	public String getCc() {
		return cc;
	}

	public void setCc(String cc) {
		this.cc = cc;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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
