package com.tabla.proyecto.service.impl;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tabla.proyecto.converter.Componente13Converter;
import com.tabla.proyecto.entity.Componente13;
import com.tabla.proyecto.model.Componente13Model;
import com.tabla.proyecto.repository.Componente13Repository;
import com.tabla.proyecto.service.Componente13Service;

@Service("componente13Service")
public class Componente13ServiceImpl implements Componente13Service{
	
	@Autowired
	@Qualifier("componente13Repository")
	private Componente13Repository componente13Repository;
	
	@Autowired
	@Qualifier("componente13Converter")
	private Componente13Converter  componente13Converter;
	
	@Override
	@Transactional(readOnly = true)
	public List<Componente13Model> findAll() {
		List<Componente13> listEntity = componente13Repository.findAll();
		List<Componente13Model> listModel = new LinkedList<>();
		for(Componente13 entity:listEntity) {
			listModel.add(componente13Converter.aModel(entity));
		}
		return listModel;
	}

	@Override
	@Transactional(readOnly = true)
	public Componente13Model findById(Long id) {
		return componente13Converter.aModel(componente13Repository.findById(id).orElse(null));
	}

	@Override
	@Transactional
	public void save(Componente13Model model) {
		componente13Repository.save(componente13Converter.aEntity(model));		
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		componente13Repository.deleteById(id);
	}
}
