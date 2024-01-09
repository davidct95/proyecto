package com.tabla.proyecto.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "componente13", schema = "tabla")
public class Componente13 {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "gid")
	private Long id;
	
	@Column(name = "componente")
	private String componente;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "enlace_bim")
	private String enlace_bim;
	
	@Column(name = "sector")
	private Double sector;
	
	@Column(name = "paquete")
	private Double paquete;
	
	@Column(name = "codigo")
	private String codigo;

	public Componente13() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getComponente() {
		return componente;
	}

	public void setComponente(String componente) {
		this.componente = componente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEnlace_bim() {
		return enlace_bim;
	}

	public void setEnlace_bim(String enlace_bim) {
		this.enlace_bim = enlace_bim;
	}

	public Double getSector() {
		return sector;
	}

	public void setSector(Double sector) {
		this.sector = sector;
	}

	public Double getPaquete() {
		return paquete;
	}

	public void setPaquete(Double paquete) {
		this.paquete = paquete;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}	
}


