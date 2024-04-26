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

	@Override
	@Transactional
	public void upload(Componente13Model model) {
		componente13Repository.save(componente13Converter.aEntity(model));
	}

	@Override
	public Componente13 actualizarComponente(Long id, Componente13Model componenteActualizado) {

		Componente13 componenteExistente = componente13Repository.findById(id).orElse(null);
		Componente13Model componenteExistenteModel =  componente13Converter.aModel(componenteExistente);

		if (componenteExistenteModel != null) {

			//Componentes
			componenteExistenteModel.setComponente(componenteActualizado.getComponente());
			componenteExistenteModel.setNombre(componenteActualizado.getNombre());
			componenteExistenteModel.setSector(componenteActualizado.getSector());
			componenteExistenteModel.setPaquete(componenteActualizado.getPaquete());
			componenteExistenteModel.setEnlace_bim(componenteActualizado.getEnlace_bim());

			//Propiedades
			componenteExistenteModel.setDai_01_00_id_valor(componenteActualizado.getDai_01_00_id_valor());
			componenteExistenteModel.setDai_01_01_proyecto_valor(componenteActualizado.getDai_01_01_proyecto_valor());
			componenteExistenteModel.setDai_01_02_localizador_valor(componenteActualizado.getDai_01_02_localizador_valor());
			componenteExistenteModel.setDai_01_03_estado_valor(componenteActualizado.getDai_01_03_estado_valor());
			componenteExistenteModel.setDai_01_04_clasificacion_valor(componenteActualizado.getDai_01_04_clasificacion_valor());
			componenteExistenteModel.setDai_01_05_tipologia_valor(componenteActualizado.getDai_01_05_tipologia_valor());
			componenteExistenteModel.setDai_01_06_disciplina_valor(componenteActualizado.getDai_01_06_disciplina_valor());
			componenteExistenteModel.setDai_01_07_subdisciplina_valor(componenteActualizado.getDai_01_07_subdisciplina_valor());
			componenteExistenteModel.setDai_01_08_material_valor(componenteActualizado.getDai_01_08_material_valor());
			componenteExistenteModel.setDai_02_01_unidad_valor(componenteActualizado.getDai_02_01_unidad_valor());
			componenteExistenteModel.setDai_02_02_longitud_valor(componenteActualizado.getDai_02_02_longitud_valor());
			componenteExistenteModel.setDai_02_03_espesor_valor(componenteActualizado.getDai_02_03_espesor_valor());
			componenteExistenteModel.setDai_02_04_area_valor(componenteActualizado.getDai_02_04_area_valor());
			componenteExistenteModel.setDai_02_05_volumen_valor(componenteActualizado.getDai_02_05_volumen_valor());
			componenteExistenteModel.setDai_03_01_faseobra_valor(componenteActualizado.getDai_03_01_faseobra_valor());
			componenteExistenteModel.setDai_03_02_plano_valor(componenteActualizado.getDai_03_02_plano_valor());
			componenteExistenteModel.setDai_03_03_pptp_valor(componenteActualizado.getDai_03_03_pptp_valor());
			componenteExistenteModel.setDai_03_04_01_udmedicion01_valor_valor(componenteActualizado.getDai_03_04_01_udmedicion01_valor_valor());
			componenteExistenteModel.setDai_03_04_02_udmedicion02_valor(componenteActualizado.getDai_03_04_02_udmedicion02_valor());
			componenteExistenteModel.setDai_03_04_03_udmedicion03_valor(componenteActualizado.getDai_03_04_03_udmedicion03_valor());
			componenteExistenteModel.setDai_04_01_controlesdecalidad_valor(componenteActualizado.getDai_04_01_controlesdecalidad_valor());
			componenteExistenteModel.setDai_04_02_fotografias(componenteActualizado.getDai_04_02_fotografias());
			componenteExistenteModel.setDai_04_03_seguridadysalud(componenteActualizado.getDai_04_03_seguridadysalud());
			componenteExistenteModel.setDai_04_04_informesdeaprobacion_valor(componenteActualizado.getDai_04_04_informesdeaprobacion_valor());
			componenteExistenteModel.setDai_04_05_certificaciones_valor(componenteActualizado.getDai_04_05_certificaciones_valor());
			componenteExistenteModel.setDai_04_06_planosasbuilt_valor(componenteActualizado.getDai_04_06_planosasbuilt_valor());
			componenteExistenteModel.setDai_04_07_medioambiente_valor(componenteActualizado.getDai_04_07_medioambiente_valor());
			componenteExistenteModel.setDai_05_01_01_necesitamantenimiento_valor(componenteActualizado.getDai_05_01_01_necesitamantenimiento_valor());
			componenteExistenteModel.setDai_05_01_02_auxmantenimiento_valor(componenteActualizado.getDai_05_01_02_auxmantenimiento_valor());
			componenteExistenteModel.setDai_05_02_01_codexplotacion_valor(componenteActualizado.getDai_05_02_01_codexplotacion_valor());
			componenteExistenteModel.setDai_05_02_02_auxexplotacion_valor(componenteActualizado.getDai_05_02_02_auxexplotacion_valor());
			componenteExistenteModel.setDai_05_03_01_codcontable_valor(componenteActualizado.getDai_05_03_01_codcontable_valor());
			componenteExistenteModel.setDai_05_03_02_auxcontable_valor(componenteActualizado.getDai_05_03_02_auxcontable_valor());

			// Asígnale otras propiedades que necesites actualizar

			Componente13 componenteExistenteEntity = componente13Converter.aEntity(componenteExistenteModel);

			return componente13Repository.save(componenteExistenteEntity);
		} else {
			return null;
		}
	}
}
