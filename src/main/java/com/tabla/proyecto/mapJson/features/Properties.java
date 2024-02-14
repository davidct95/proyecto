package com.tabla.proyecto.mapJson.features;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Properties {

    @JsonProperty("COMPONENTE")
    private String componente;
    @JsonProperty("NOMBRE")
    private String nombre;
    @JsonProperty("ENLACE_BIM")
    private String enlaceBim;
    @JsonProperty("SECTOR")
    private Double sector;
    @JsonProperty("PAQUETE")
    private Double paquete;
    @JsonProperty("CODIGO")
    private String codigo;

    public Properties() {
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

    public String getEnlaceBim() {
        return enlaceBim;
    }

    public void setEnlaceBim(String enlaceBim) {
        this.enlaceBim = enlaceBim;
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
