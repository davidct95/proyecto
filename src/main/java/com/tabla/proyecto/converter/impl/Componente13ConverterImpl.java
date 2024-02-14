package com.tabla.proyecto.converter.impl;

import org.locationtech.jts.geom.*;
import org.springframework.stereotype.Component;

import com.tabla.proyecto.converter.Componente13Converter;
import com.tabla.proyecto.entity.Componente13;
import com.tabla.proyecto.model.Componente13Model;

import java.util.ArrayList;
import java.util.List;

@Component("componente13Converter")
public class Componente13ConverterImpl implements Componente13Converter{

	@Override
	public Componente13 aEntity(Componente13Model model) {
		Componente13 entity = new Componente13();
		entity.setId(model.getId());
		entity.setType_(model.getType_());
		entity.setName_(model.getName_());
		entity.setCrs_type(model.getCrs_type());
		entity.setCrs_properties_name(model.getCrs_properties_name());
		entity.setFeatures_type(model.getFeatures_type());
		entity.setGeometry_type(model.getGeometry_type());
		entity.setComponente(model.getComponente());
		entity.setNombre(model.getNombre());
		entity.setEnlace_bim(model.getEnlace_bim());
		entity.setSector(model.getSector());
		entity.setPaquete(model.getPaquete());
		entity.setCodigo(model.getCodigo());

		List<List<List<List<Double>>>> coordinates = model.getCoordinates();

		if(coordinates!= null){
			GeometryFactory gf = new GeometryFactory();
			List<Polygon> polygons = new ArrayList<>();

			for (List<List<List<Double>>> polygonCoordinates : coordinates) {
				List<Coordinate> exteriorRing = new ArrayList<>();
				for (List<List<Double>> ring : polygonCoordinates) {
					for (List<Double> point : ring) {
						Coordinate coordinate = new Coordinate(point.get(0), point.get(1));
						exteriorRing.add(coordinate);
					}
				}
				// Crear el anillo exterior
				LinearRing shell = gf.createLinearRing(exteriorRing.toArray(new Coordinate[0]));
				// Crear el polígono
				Polygon polygon = gf.createPolygon(shell);
				polygons.add(polygon);
			}
			// Crear el MultiPolygon
			MultiPolygon multiPolygon = gf.createMultiPolygon(polygons.toArray(new Polygon[0]));

			multiPolygon.setSRID(32717);

			entity.setGeom(multiPolygon);
		} else {
			System.out.println("Coordinates es null");
		}

	    // Nuevas propiedades agregadas
	    entity.setDai_01_00_id_valor(model.getDai_01_00_id_valor());
	    entity.setDai_01_01_proyecto_valor(model.getDai_01_01_proyecto_valor());
	    entity.setDai_01_02_localizador_valor(model.getDai_01_02_localizador_valor());
	    entity.setDai_01_03_estado_valor(model.getDai_01_03_estado_valor());
	    entity.setDai_01_04_clasificacion_valor(model.getDai_01_04_clasificacion_valor());
	    entity.setDai_01_05_tipologia_valor(model.getDai_01_05_tipologia_valor());
	    entity.setDai_01_06_disciplina_valor(model.getDai_01_06_disciplina_valor());
	    entity.setDai_01_07_subdisciplina_valor(model.getDai_01_07_subdisciplina_valor());
	    entity.setDai_01_08_material_valor(model.getDai_01_08_material_valor());
	    entity.setDai_02_01_unidad_valor(model.getDai_02_01_unidad_valor());
	    entity.setDai_02_02_longitud_valor(model.getDai_02_02_longitud_valor());
	    entity.setDai_02_03_espesor_valor(model.getDai_02_03_espesor_valor());
	    entity.setDai_02_04_area_valor(model.getDai_02_04_area_valor());
	    entity.setDai_02_05_volumen_valor(model.getDai_02_05_volumen_valor());
	    entity.setDai_03_01_faseobra_valor(model.getDai_03_01_faseobra_valor());
	    entity.setDai_03_02_plano_valor(model.getDai_03_02_plano_valor());
	    entity.setDai_03_03_pptp_valor(model.getDai_03_03_pptp_valor());
	    entity.setDai_03_04_01_udmedicion01_valor_valor(model.getDai_03_04_01_udmedicion01_valor_valor());
	    entity.setDai_03_04_02_udmedicion02_valor(model.getDai_03_04_02_udmedicion02_valor());
	    entity.setDai_03_04_03_udmedicion03_valor(model.getDai_03_04_03_udmedicion03_valor());
	    entity.setDai_04_01_controlesdecalidad_valor(model.getDai_04_01_controlesdecalidad_valor());
	    entity.setDai_04_02_fotografias(model.getDai_04_02_fotografias());
	    entity.setDai_04_03_seguridadysalud(model.getDai_04_03_seguridadysalud());
	    entity.setDai_04_04_informesdeaprobacion_valor(model.getDai_04_04_informesdeaprobacion_valor());
	    entity.setDai_04_05_certificaciones_valor(model.getDai_04_05_certificaciones_valor());
	    entity.setDai_04_06_planosasbuilt_valor(model.getDai_04_06_planosasbuilt_valor());
	    entity.setDai_04_07_medioambiente_valor(model.getDai_04_07_medioambiente_valor());
	    entity.setDai_05_01_01_necesitamantenimiento_valor(model.getDai_05_01_01_necesitamantenimiento_valor());
	    entity.setDai_05_01_02_auxmantenimiento_valor(model.getDai_05_01_02_auxmantenimiento_valor());
	    entity.setDai_05_02_01_codexplotacion_valor(model.getDai_05_02_01_codexplotacion_valor());
	    entity.setDai_05_02_02_auxexplotacion_valor(model.getDai_05_02_02_auxexplotacion_valor());
	    entity.setDai_05_03_01_codcontable_valor(model.getDai_05_03_01_codcontable_valor());
	    entity.setDai_05_03_02_auxcontable_valor(model.getDai_05_03_02_auxcontable_valor());

		return entity;
	}

	@Override
	public Componente13Model aModel(Componente13 entity) {
		Componente13Model model = new Componente13Model();
		model.setId(entity.getId());
		model.setType_(entity.getType_());
		model.setName_(entity.getName_());
		model.setCrs_type(entity.getCrs_type());
		model.setCrs_properties_name(entity.getCrs_properties_name());
		model.setFeatures_type(entity.getFeatures_type());
		model.setGeometry_type(entity.getGeometry_type());
		model.setComponente(entity.getComponente());
		model.setNombre(entity.getNombre());
		model.setEnlace_bim(entity.getEnlace_bim());
		model.setSector(entity.getSector());
		model.setPaquete(entity.getPaquete());
		model.setCodigo(entity.getCodigo());


		//Convertir de Geom a List

		List<List<List<List<Double>>>> coordinates = new ArrayList<>();

		MultiPolygon multiPolygon = entity.getGeom();

		for (int i = 0; i < multiPolygon.getNumGeometries(); i++) {
			List<List<List<Double>>> polygonCoordinates = new ArrayList<>();
			Polygon polygon = (Polygon) multiPolygon.getGeometryN(i);

			// Convertir el anillo exterior del polígono
			List<List<Double>> exteriorRingCoordinates = new ArrayList<>();
			LineString exteriorRing = polygon.getExteriorRing();
			Coordinate[] exteriorCoords = exteriorRing.getCoordinates();
			for (Coordinate coord : exteriorCoords) {
				List<Double> point = new ArrayList<>();
				point.add(coord.x);
				point.add(coord.y);
				//point.add(coord.z); // Añadir coordenada z si es necesario
				//point.add(coord.getM()); // Añadir coordenada m si es necesario
				exteriorRingCoordinates.add(point);
			}
			polygonCoordinates.add(exteriorRingCoordinates);

			// Convertir los anillos interiores del polígono (agujeros)
			for (int j = 0; j < polygon.getNumInteriorRing(); j++) {
				List<List<Double>> interiorRingCoordinates = new ArrayList<>();
				LineString interiorRing = polygon.getInteriorRingN(j);
				Coordinate[] interiorCoords = interiorRing.getCoordinates();
				for (Coordinate coord : interiorCoords) {
					List<Double> point = new ArrayList<>();
					point.add(coord.x);
					point.add(coord.y);
					//point.add(coord.z); // Añadir coordenada z si es necesario
					//point.add(coord.getM()); // Añadir coordenada m si es necesario
					interiorRingCoordinates.add(point);
				}
				polygonCoordinates.add(interiorRingCoordinates);
			}

			coordinates.add(polygonCoordinates);
		}

		model.setCoordinates(coordinates);



	    // Nuevas propiedades agregadas
	    model.setDai_01_00_id_valor(entity.getDai_01_00_id_valor());
	    model.setDai_01_01_proyecto_valor(entity.getDai_01_01_proyecto_valor());
	    model.setDai_01_02_localizador_valor(entity.getDai_01_02_localizador_valor());
	    model.setDai_01_03_estado_valor(entity.getDai_01_03_estado_valor());
	    model.setDai_01_04_clasificacion_valor(entity.getDai_01_04_clasificacion_valor());
	    model.setDai_01_05_tipologia_valor(entity.getDai_01_05_tipologia_valor());
	    model.setDai_01_06_disciplina_valor(entity.getDai_01_06_disciplina_valor());
	    model.setDai_01_07_subdisciplina_valor(entity.getDai_01_07_subdisciplina_valor());
	    model.setDai_01_08_material_valor(entity.getDai_01_08_material_valor());
	    model.setDai_02_01_unidad_valor(entity.getDai_02_01_unidad_valor());
	    model.setDai_02_02_longitud_valor(entity.getDai_02_02_longitud_valor());
	    model.setDai_02_03_espesor_valor(entity.getDai_02_03_espesor_valor());
	    model.setDai_02_04_area_valor(entity.getDai_02_04_area_valor());
	    model.setDai_02_05_volumen_valor(entity.getDai_02_05_volumen_valor());
	    model.setDai_03_01_faseobra_valor(entity.getDai_03_01_faseobra_valor());
	    model.setDai_03_02_plano_valor(entity.getDai_03_02_plano_valor());
	    model.setDai_03_03_pptp_valor(entity.getDai_03_03_pptp_valor());
	    model.setDai_03_04_01_udmedicion01_valor_valor(entity.getDai_03_04_01_udmedicion01_valor_valor());
	    model.setDai_03_04_02_udmedicion02_valor(entity.getDai_03_04_02_udmedicion02_valor());
	    model.setDai_03_04_03_udmedicion03_valor(entity.getDai_03_04_03_udmedicion03_valor());
	    model.setDai_04_01_controlesdecalidad_valor(entity.getDai_04_01_controlesdecalidad_valor());
	    model.setDai_04_02_fotografias(entity.getDai_04_02_fotografias());
	    model.setDai_04_03_seguridadysalud(entity.getDai_04_03_seguridadysalud());
	    model.setDai_04_04_informesdeaprobacion_valor(entity.getDai_04_04_informesdeaprobacion_valor());
	    model.setDai_04_05_certificaciones_valor(entity.getDai_04_05_certificaciones_valor());
	    model.setDai_04_06_planosasbuilt_valor(entity.getDai_04_06_planosasbuilt_valor());
	    model.setDai_04_07_medioambiente_valor(entity.getDai_04_07_medioambiente_valor());
	    model.setDai_05_01_01_necesitamantenimiento_valor(entity.getDai_05_01_01_necesitamantenimiento_valor());
	    model.setDai_05_01_02_auxmantenimiento_valor(entity.getDai_05_01_02_auxmantenimiento_valor());
	    model.setDai_05_02_01_codexplotacion_valor(entity.getDai_05_02_01_codexplotacion_valor());
	    model.setDai_05_02_02_auxexplotacion_valor(entity.getDai_05_02_02_auxexplotacion_valor());
	    model.setDai_05_03_01_codcontable_valor(entity.getDai_05_03_01_codcontable_valor());
	    model.setDai_05_03_02_auxcontable_valor(entity.getDai_05_03_02_auxcontable_valor());

		return model;
	}
	

}
