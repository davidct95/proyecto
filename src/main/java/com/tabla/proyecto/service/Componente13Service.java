package com.tabla.proyecto.service;

import java.util.List;

import com.tabla.proyecto.model.Componente13Model;

public interface Componente13Service {
	
	List<Componente13Model> findAll();
	
	Componente13Model findById(Long id);
	
	void save(Componente13Model model);
	
	void deleteById(Long id);

}
