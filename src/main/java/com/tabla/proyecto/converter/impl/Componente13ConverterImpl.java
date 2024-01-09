package com.tabla.proyecto.converter.impl;

import org.springframework.stereotype.Component;

import com.tabla.proyecto.converter.Componente13Converter;
import com.tabla.proyecto.entity.Componente13;
import com.tabla.proyecto.model.Componente13Model;

@Component("componente13Converter")
public class Componente13ConverterImpl implements Componente13Converter{

	@Override
	public Componente13 aEntity(Componente13Model model) {
		Componente13 entity = new Componente13();
		entity.setId(model.getId());
		entity.setComponente(model.getComponente());
		entity.setNombre(model.getNombre());
		entity.setEnlace_bim(model.getEnlace_bim());
		entity.setSector(model.getSector());
		entity.setPaquete(model.getPaquete());
		entity.setCodigo(model.getCodigo());
		return entity;
	}

	@Override
	public Componente13Model aModel(Componente13 entity) {
		Componente13Model model = new Componente13Model();
		model.setId(entity.getId());
		model.setComponente(entity.getComponente());
		model.setNombre(entity.getNombre());
		model.setEnlace_bim(entity.getEnlace_bim());
		model.setSector(entity.getSector());
		model.setPaquete(entity.getPaquete());
		model.setCodigo(entity.getCodigo());
		return model;
	}
	

}
