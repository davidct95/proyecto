package com.tabla.proyecto.model;

public class Componente13Model {
	
	private Long id;

	private String componente;

	private String nombre;
	
	private String enlace_bim;
	
	private Double sector;

	private Double paquete;
	
	private String codigo;

	public Componente13Model() {
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

	@Override
	public String toString() {
		return "Componente13Model [id=" + id + ", componente=" + componente + ", nombre=" + nombre + ", enlace_bim="
				+ enlace_bim + ", sector=" + sector + ", paquete=" + paquete + ", codigo=" + codigo + "]";
	}
	
}
