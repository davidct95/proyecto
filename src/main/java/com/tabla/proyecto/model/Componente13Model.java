package com.tabla.proyecto.model;

import java.util.List;

public class Componente13Model {
	
	private Long id;
	private String type_;
	private String name_;
	private String crs_type;
	private String crs_properties_name;
	private String features_type;
	private String geometry_type;

	private String componente;

	private String nombre;
	
	private String enlace_bim;
	
	private Double sector;

	private Double paquete;
	
	private String codigo;

	private List<List<List<List<Double>>>> coordinates;

	private String dai_01_00_id_valor;
	private String dai_01_01_proyecto_valor;
	private String dai_01_02_localizador_valor;
	private String dai_01_03_estado_valor;
	private String dai_01_04_clasificacion_valor;
	private String dai_01_05_tipologia_valor;
	private String dai_01_06_disciplina_valor;
	private String dai_01_07_subdisciplina_valor;
	private String dai_01_08_material_valor;
	private Integer dai_02_01_unidad_valor;
	private Double dai_02_02_longitud_valor;
	private Double dai_02_03_espesor_valor;
	private Double dai_02_04_area_valor;
	private Double dai_02_05_volumen_valor;
	private String dai_03_01_faseobra_valor;
	private String dai_03_02_plano_valor;
	private String dai_03_03_pptp_valor;
	private String dai_03_04_01_udmedicion01_valor_valor;
	private String dai_03_04_02_udmedicion02_valor;
	private String dai_03_04_03_udmedicion03_valor;
	private String dai_04_01_controlesdecalidad_valor;
	private String dai_04_02_fotografias;
	private String dai_04_03_seguridadysalud;
	private String dai_04_04_informesdeaprobacion_valor;
	private String dai_04_05_certificaciones_valor;
	private String dai_04_06_planosasbuilt_valor;
	private String dai_04_07_medioambiente_valor;
	private String dai_05_01_01_necesitamantenimiento_valor;
	private String dai_05_01_02_auxmantenimiento_valor;
	private String dai_05_02_01_codexplotacion_valor;
	private String dai_05_02_02_auxexplotacion_valor;
	private String dai_05_03_01_codcontable_valor;
	private String dai_05_03_02_auxcontable_valor;
	
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

	public String getDai_01_00_id_valor() {
		return dai_01_00_id_valor;
	}

	public void setDai_01_00_id_valor(String dai_01_00_id_valor) {
		this.dai_01_00_id_valor = dai_01_00_id_valor;
	}

	public String getDai_01_01_proyecto_valor() {
		return dai_01_01_proyecto_valor;
	}

	public void setDai_01_01_proyecto_valor(String dai_01_01_proyecto_valor) {
		this.dai_01_01_proyecto_valor = dai_01_01_proyecto_valor;
	}

	public String getDai_01_02_localizador_valor() {
		return dai_01_02_localizador_valor;
	}

	public void setDai_01_02_localizador_valor(String dai_01_02_localizador_valor) {
		this.dai_01_02_localizador_valor = dai_01_02_localizador_valor;
	}

	public String getDai_01_03_estado_valor() {
		return dai_01_03_estado_valor;
	}

	public void setDai_01_03_estado_valor(String dai_01_03_estado_valor) {
		this.dai_01_03_estado_valor = dai_01_03_estado_valor;
	}

	public String getDai_01_04_clasificacion_valor() {
		return dai_01_04_clasificacion_valor;
	}

	public void setDai_01_04_clasificacion_valor(String dai_01_04_clasificacion_valor) {
		this.dai_01_04_clasificacion_valor = dai_01_04_clasificacion_valor;
	}

	public String getDai_01_05_tipologia_valor() {
		return dai_01_05_tipologia_valor;
	}

	public void setDai_01_05_tipologia_valor(String dai_01_05_tipologia_valor) {
		this.dai_01_05_tipologia_valor = dai_01_05_tipologia_valor;
	}

	public String getDai_01_06_disciplina_valor() {
		return dai_01_06_disciplina_valor;
	}

	public void setDai_01_06_disciplina_valor(String dai_01_06_disciplina_valor) {
		this.dai_01_06_disciplina_valor = dai_01_06_disciplina_valor;
	}

	public String getDai_01_07_subdisciplina_valor() {
		return dai_01_07_subdisciplina_valor;
	}

	public void setDai_01_07_subdisciplina_valor(String dai_01_07_subdisciplina_valor) {
		this.dai_01_07_subdisciplina_valor = dai_01_07_subdisciplina_valor;
	}

	public String getDai_01_08_material_valor() {
		return dai_01_08_material_valor;
	}

	public void setDai_01_08_material_valor(String dai_01_08_material_valor) {
		this.dai_01_08_material_valor = dai_01_08_material_valor;
	}

	public Integer getDai_02_01_unidad_valor() {
		return dai_02_01_unidad_valor;
	}

	public void setDai_02_01_unidad_valor(Integer dai_02_01_unidad_valor) {
		this.dai_02_01_unidad_valor = dai_02_01_unidad_valor;
	}

	public Double getDai_02_02_longitud_valor() {
		return dai_02_02_longitud_valor;
	}

	public void setDai_02_02_longitud_valor(Double dai_02_02_longitud_valor) {
		this.dai_02_02_longitud_valor = dai_02_02_longitud_valor;
	}

	public Double getDai_02_03_espesor_valor() {
		return dai_02_03_espesor_valor;
	}

	public void setDai_02_03_espesor_valor(Double dai_02_03_espesor_valor) {
		this.dai_02_03_espesor_valor = dai_02_03_espesor_valor;
	}

	public Double getDai_02_04_area_valor() {
		return dai_02_04_area_valor;
	}

	public void setDai_02_04_area_valor(Double dai_02_04_area_valor) {
		this.dai_02_04_area_valor = dai_02_04_area_valor;
	}

	public Double getDai_02_05_volumen_valor() {
		return dai_02_05_volumen_valor;
	}

	public void setDai_02_05_volumen_valor(Double dai_02_05_volumen_valor) {
		this.dai_02_05_volumen_valor = dai_02_05_volumen_valor;
	}

	public String getDai_03_01_faseobra_valor() {
		return dai_03_01_faseobra_valor;
	}

	public void setDai_03_01_faseobra_valor(String dai_03_01_faseobra_valor) {
		this.dai_03_01_faseobra_valor = dai_03_01_faseobra_valor;
	}

	public String getDai_03_02_plano_valor() {
		return dai_03_02_plano_valor;
	}

	public void setDai_03_02_plano_valor(String dai_03_02_plano_valor) {
		this.dai_03_02_plano_valor = dai_03_02_plano_valor;
	}

	public String getDai_03_03_pptp_valor() {
		return dai_03_03_pptp_valor;
	}

	public void setDai_03_03_pptp_valor(String dai_03_03_pptp_valor) {
		this.dai_03_03_pptp_valor = dai_03_03_pptp_valor;
	}

	public String getDai_03_04_01_udmedicion01_valor_valor() {
		return dai_03_04_01_udmedicion01_valor_valor;
	}

	public void setDai_03_04_01_udmedicion01_valor_valor(String dai_03_04_01_udmedicion01_valor_valor) {
		this.dai_03_04_01_udmedicion01_valor_valor = dai_03_04_01_udmedicion01_valor_valor;
	}

	public String getDai_03_04_02_udmedicion02_valor() {
		return dai_03_04_02_udmedicion02_valor;
	}

	public void setDai_03_04_02_udmedicion02_valor(String dai_03_04_02_udmedicion02_valor) {
		this.dai_03_04_02_udmedicion02_valor = dai_03_04_02_udmedicion02_valor;
	}

	public String getDai_03_04_03_udmedicion03_valor() {
		return dai_03_04_03_udmedicion03_valor;
	}

	public void setDai_03_04_03_udmedicion03_valor(String dai_03_04_03_udmedicion03_valor) {
		this.dai_03_04_03_udmedicion03_valor = dai_03_04_03_udmedicion03_valor;
	}

	public String getDai_04_01_controlesdecalidad_valor() {
		return dai_04_01_controlesdecalidad_valor;
	}

	public void setDai_04_01_controlesdecalidad_valor(String dai_04_01_controlesdecalidad_valor) {
		this.dai_04_01_controlesdecalidad_valor = dai_04_01_controlesdecalidad_valor;
	}

	public String getDai_04_02_fotografias() {
		return dai_04_02_fotografias;
	}

	public void setDai_04_02_fotografias(String dai_04_02_fotografias) {
		this.dai_04_02_fotografias = dai_04_02_fotografias;
	}

	public String getDai_04_03_seguridadysalud() {
		return dai_04_03_seguridadysalud;
	}

	public void setDai_04_03_seguridadysalud(String dai_04_03_seguridadysalud) {
		this.dai_04_03_seguridadysalud = dai_04_03_seguridadysalud;
	}

	public String getDai_04_04_informesdeaprobacion_valor() {
		return dai_04_04_informesdeaprobacion_valor;
	}

	public void setDai_04_04_informesdeaprobacion_valor(String dai_04_04_informesdeaprobacion_valor) {
		this.dai_04_04_informesdeaprobacion_valor = dai_04_04_informesdeaprobacion_valor;
	}

	public String getDai_04_05_certificaciones_valor() {
		return dai_04_05_certificaciones_valor;
	}

	public void setDai_04_05_certificaciones_valor(String dai_04_05_certificaciones_valor) {
		this.dai_04_05_certificaciones_valor = dai_04_05_certificaciones_valor;
	}

	public String getDai_04_06_planosasbuilt_valor() {
		return dai_04_06_planosasbuilt_valor;
	}

	public void setDai_04_06_planosasbuilt_valor(String dai_04_06_planosasbuilt_valor) {
		this.dai_04_06_planosasbuilt_valor = dai_04_06_planosasbuilt_valor;
	}

	public String getDai_04_07_medioambiente_valor() {
		return dai_04_07_medioambiente_valor;
	}

	public void setDai_04_07_medioambiente_valor(String dai_04_07_medioambiente_valor) {
		this.dai_04_07_medioambiente_valor = dai_04_07_medioambiente_valor;
	}

	public String getDai_05_01_01_necesitamantenimiento_valor() {
		return dai_05_01_01_necesitamantenimiento_valor;
	}

	public void setDai_05_01_01_necesitamantenimiento_valor(String dai_05_01_01_necesitamantenimiento_valor) {
		this.dai_05_01_01_necesitamantenimiento_valor = dai_05_01_01_necesitamantenimiento_valor;
	}

	public String getDai_05_01_02_auxmantenimiento_valor() {
		return dai_05_01_02_auxmantenimiento_valor;
	}

	public void setDai_05_01_02_auxmantenimiento_valor(String dai_05_01_02_auxmantenimiento_valor) {
		this.dai_05_01_02_auxmantenimiento_valor = dai_05_01_02_auxmantenimiento_valor;
	}

	public String getDai_05_02_01_codexplotacion_valor() {
		return dai_05_02_01_codexplotacion_valor;
	}

	public void setDai_05_02_01_codexplotacion_valor(String dai_05_02_01_codexplotacion_valor) {
		this.dai_05_02_01_codexplotacion_valor = dai_05_02_01_codexplotacion_valor;
	}

	public String getDai_05_02_02_auxexplotacion_valor() {
		return dai_05_02_02_auxexplotacion_valor;
	}

	public void setDai_05_02_02_auxexplotacion_valor(String dai_05_02_02_auxexplotacion_valor) {
		this.dai_05_02_02_auxexplotacion_valor = dai_05_02_02_auxexplotacion_valor;
	}

	public String getDai_05_03_01_codcontable_valor() {
		return dai_05_03_01_codcontable_valor;
	}

	public void setDai_05_03_01_codcontable_valor(String dai_05_03_01_codcontable_valor) {
		this.dai_05_03_01_codcontable_valor = dai_05_03_01_codcontable_valor;
	}

	public String getDai_05_03_02_auxcontable_valor() {
		return dai_05_03_02_auxcontable_valor;
	}

	public void setDai_05_03_02_auxcontable_valor(String dai_05_03_02_auxcontable_valor) {
		this.dai_05_03_02_auxcontable_valor = dai_05_03_02_auxcontable_valor;
	}

	public List<List<List<List<Double>>>> getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(List<List<List<List<Double>>>> coordinates) {
		this.coordinates = coordinates;
	}

	public String getType_() {
		return type_;
	}

	public void setType_(String type_) {
		this.type_ = type_;
	}

	public String getName_() {
		return name_;
	}

	public void setName_(String name_) {
		this.name_ = name_;
	}

	public String getCrs_type() {
		return crs_type;
	}

	public void setCrs_type(String crs_type) {
		this.crs_type = crs_type;
	}

	public String getCrs_properties_name() {
		return crs_properties_name;
	}

	public void setCrs_properties_name(String crs_properties_name) {
		this.crs_properties_name = crs_properties_name;
	}

	public String getFeatures_type() {
		return features_type;
	}

	public void setFeatures_type(String features_type) {
		this.features_type = features_type;
	}

	public String getGeometry_type() {
		return geometry_type;
	}

	public void setGeometry_type(String geometry_type) {
		this.geometry_type = geometry_type;
	}

	@Override
	public String toString() {
		return "Componente13Model [id=" + id + ", componente=" + componente + ", nombre=" + nombre + ", enlace_bim="
				+ enlace_bim + ", sector=" + sector + ", paquete=" + paquete + ", codigo=" + codigo
				+ ", dai_01_00_id_valor=" + dai_01_00_id_valor + ", dai_01_01_proyecto_valor="
				+ dai_01_01_proyecto_valor + ", dai_01_02_localizador_valor=" + dai_01_02_localizador_valor
				+ ", dai_01_03_estado_valor=" + dai_01_03_estado_valor + ", dai_01_04_clasificacion_valor="
				+ dai_01_04_clasificacion_valor + ", dai_01_05_tipologia_valor=" + dai_01_05_tipologia_valor
				+ ", dai_01_06_disciplina_valor=" + dai_01_06_disciplina_valor + ", dai_01_07_subdisciplina_valor="
				+ dai_01_07_subdisciplina_valor + ", dai_01_08_material_valor=" + dai_01_08_material_valor
				+ ", dai_02_01_unidad_valor=" + dai_02_01_unidad_valor + ", dai_02_02_longitud_valor="
				+ dai_02_02_longitud_valor + ", dai_02_03_espesor_valor=" + dai_02_03_espesor_valor
				+ ", dai_02_04_area_valor=" + dai_02_04_area_valor + ", dai_02_05_volumen_valor="
				+ dai_02_05_volumen_valor + ", dai_03_01_faseobra_valor=" + dai_03_01_faseobra_valor
				+ ", dai_03_02_plano_valor=" + dai_03_02_plano_valor + ", dai_03_03_pptp_valor=" + dai_03_03_pptp_valor
				+ ", dai_03_04_01_udmedicion01_valor_valor=" + dai_03_04_01_udmedicion01_valor_valor
				+ ", dai_03_04_02_udmedicion02_valor=" + dai_03_04_02_udmedicion02_valor
				+ ", dai_03_04_03_udmedicion03_valor=" + dai_03_04_03_udmedicion03_valor
				+ ", dai_04_01_controlesdecalidad_valor=" + dai_04_01_controlesdecalidad_valor
				+ ", dai_04_02_fotografias=" + dai_04_02_fotografias + ", dai_04_03_seguridadysalud="
				+ dai_04_03_seguridadysalud + ", dai_04_04_informesdeaprobacion_valor="
				+ dai_04_04_informesdeaprobacion_valor + ", dai_04_05_certificaciones_valor="
				+ dai_04_05_certificaciones_valor + ", dai_04_06_planosasbuilt_valor=" + dai_04_06_planosasbuilt_valor
				+ ", dai_04_07_medioambiente_valor=" + dai_04_07_medioambiente_valor
				+ ", dai_05_01_01_necesitamantenimiento_valor=" + dai_05_01_01_necesitamantenimiento_valor
				+ ", dai_05_01_02_auxmantenimiento_valor=" + dai_05_01_02_auxmantenimiento_valor
				+ ", dai_05_02_01_codexplotacion_valor=" + dai_05_02_01_codexplotacion_valor
				+ ", dai_05_02_02_auxexplotacion_valor=" + dai_05_02_02_auxexplotacion_valor
				+ ", dai_05_03_01_codcontable_valor=" + dai_05_03_01_codcontable_valor
				+ ", dai_05_03_02_auxcontable_valor=" + dai_05_03_02_auxcontable_valor + "]";
	}

	

	
}
