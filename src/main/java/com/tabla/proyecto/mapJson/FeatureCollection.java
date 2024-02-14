package com.tabla.proyecto.mapJson;



import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tabla.proyecto.mapJson.features.Feature;

public class FeatureCollection {

    private String type;
    private String name;
    private Crs crs;
    private List<Feature> features;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Crs getCrs() {
        return crs;
    }

    public void setCrs(Crs crs) {
        this.crs = crs;
    }

    public List<Feature> getFeatures() {
        return features;
    }

    public void setFeatures(List<Feature> features) {
        this.features = features;
    }
}