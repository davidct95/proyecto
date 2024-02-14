package com.tabla.proyecto.mapJson;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Crs {

    private String type;
    private Properties properties;

    public Crs() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }
}
