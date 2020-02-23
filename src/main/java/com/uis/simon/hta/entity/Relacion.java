package com.uis.simon.hta.entity;


import javax.persistence.ManyToOne;
import javax.persistence.Table;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

@Entity
@Table(name="relacion")
public class Relacion {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	 @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	 private Simulacion simulacion;
	
	@ManyToMany
    @JoinTable(name = "dieta", joinColumns = @JoinColumn(name = "relacion_id"), inverseJoinColumns = @JoinColumn(name = "alimento_id"))
    private Set<Alimento> alimentos = new HashSet<>();
	
	
	@ManyToMany
    @JoinTable(name = "actividadFisica", joinColumns = @JoinColumn(name = "relacion_id"), inverseJoinColumns = @JoinColumn(name = "actividad_id"))
    private Set<Actividad> actividad = new HashSet<>();
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Simulacion getSimulacion() {
		return simulacion;
	}

	public void setSimulacion(Simulacion simulacion) {
		this.simulacion = simulacion;
	}
	
}
