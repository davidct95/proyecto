package com.tabla.proyecto.controller;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tabla.proyecto.entity.Componente13;
import com.tabla.proyecto.mapJson.Crs;
import com.tabla.proyecto.mapJson.FeatureCollection;
import com.tabla.proyecto.mapJson.Properties;
import com.tabla.proyecto.mapJson.features.Feature;
import com.tabla.proyecto.mapJson.features.Geometry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.tabla.proyecto.model.Componente13Model;
import com.tabla.proyecto.service.Componente13Service;
import org.springframework.web.multipart.MultipartFile;

@CrossOrigin(origins = "http://localhost:4200")
@Controller
@RequestMapping("/home")
@SessionAttributes("componentes")
public class Componente13Controller {

    @Autowired
    @Qualifier("componente13Service")
    private Componente13Service componente13Service;

    @GetMapping("/show")
    public String dataAll(Model model) {
        List<Componente13Model> listModel = componente13Service.findAll();
        model.addAttribute("listComponentes", listModel);
        return "componentes";
    }

    @GetMapping("/componentesbd")
    @ResponseBody
    public List<Componente13Model> getComponentes() {
        List<Componente13Model> listModel = componente13Service.findAll();
        return listModel;
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("componentes", new Componente13Model());
        return "componentesForm";
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/buscar/{id}")
    @ResponseBody
    public String findById(@PathVariable Long id) {

        Componente13Model componente13Model = componente13Service.findById(id);

        ObjectMapper objectMapper = new ObjectMapper();

        FeatureCollection featureCollection = new FeatureCollection();

        featureCollection.setType(componente13Model.getType_());
        featureCollection.setName(componente13Model.getName_());

        //Ingresando datos del CRS

        Crs crs = new Crs();
        crs.setType(componente13Model.getCrs_type());
        Properties properties = new Properties();
        properties.setName(componente13Model.getCrs_properties_name());
        crs.setProperties(properties);
        featureCollection.setCrs(crs);

        //Ingresando datos de Feature

        Feature feature = new Feature();
        List<Feature> listFeature = new ArrayList<>();

        feature.setType(componente13Model.getFeatures_type());

        com.tabla.proyecto.mapJson.features.Properties featuresProperties = new com.tabla.proyecto.mapJson.features.Properties();
        featuresProperties.setId(componente13Model.getId());
        featuresProperties.setComponente(componente13Model.getComponente());
        featuresProperties.setCodigo(componente13Model.getCodigo());
        featuresProperties.setEnlaceBim(componente13Model.getEnlace_bim());
        featuresProperties.setSector(componente13Model.getSector());
        featuresProperties.setPaquete(componente13Model.getPaquete());
        featuresProperties.setNombre(componente13Model.getNombre());

        Geometry featuresGeometry = new Geometry();

        featuresGeometry.setCoordinates(componente13Model.getCoordinates());
        featuresGeometry.setType(componente13Model.getGeometry_type());

        feature.setGeometry(featuresGeometry);

        feature.setProperties(featuresProperties);

        listFeature.add(feature);

        featureCollection.setFeatures(listFeature);


        try {
            String s = objectMapper.writeValueAsString(featureCollection);
            return s;

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }


    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("componentes", componente13Service.findById(id));
        return "componentesForm";
    }

    @GetMapping("/propiedades/{id}")
    public String propiedades(@PathVariable Long id, Model model) {
        model.addAttribute("componentes", componente13Service.findById(id));
        return "propiedades";
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("p/{id}")
    @ResponseBody
    public Componente13Model datosPropiedades(@PathVariable Long id) {
        return componente13Service.findById(id);
    }

    @PostMapping("/save")
    public String guardar(@ModelAttribute("componentes") Componente13Model model) {
        componente13Service.save(model);
        return "redirect:/home/show";
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Componente13> actualizarComponente(@PathVariable Long id, @RequestBody Componente13Model componenteActualizado) {
        Componente13 componenteActualizadoEnDB = componente13Service.actualizarComponente(id, componenteActualizado);

        if (componenteActualizadoEnDB != null) {
            return ResponseEntity.ok(componenteActualizadoEnDB);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/del/{id}")
    public String delete(@PathVariable Long id) {
        componente13Service.deleteById(id);
        return "redirect:/home/show";
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminarRegistro(@PathVariable Long id) {
        componente13Service.deleteById(id);
    }

    @PostMapping("/upload")
    public String uploadFile(@RequestPart("file") MultipartFile file) {
        // Procesar el archivo
        if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();
                // Aquí puedes guardar el archivo en una variable o hacer el procesamiento que necesites
                // Por ejemplo:
                String geoJson = new String(bytes);
                System.out.println("Contenido del archivo:\n" + geoJson);

                ObjectMapper objectMapper = new ObjectMapper();
                FeatureCollection featureCollection = objectMapper.readValue(geoJson, FeatureCollection.class);

                String type = featureCollection.getType();
                String name = featureCollection.getName();
                Crs crs = featureCollection.getCrs();
                String crs_type = crs.getType();
                Properties crs_properties = crs.getProperties();
                String crs_properties_name = crs_properties.getName();


                for (Feature features : featureCollection.getFeatures()) {

                    String features_type = features.getType();
                    String geometry_type = features.getGeometry().getType();

                    List<List<List<List<Double>>>> coordinates = features.getGeometry().getCoordinates();
                    String componente = features.getProperties().getComponente();
                    String nombre = features.getProperties().getNombre();
                    String enlace_bim = features.getProperties().getEnlaceBim();
                    Double sector = (double) features.getProperties().getSector();
                    Double paquete = (double) features.getProperties().getPaquete();
                    String codigo = features.getProperties().getCodigo();

                    Componente13Model componente13Model = new Componente13Model();

                    componente13Model.setType_(type);
                    componente13Model.setName_(name);
                    componente13Model.setCrs_type(crs_type);
                    componente13Model.setCrs_properties_name(crs_properties_name);
                    componente13Model.setGeometry_type(geometry_type);

                    componente13Model.setFeatures_type(features_type);

                    componente13Model.setCoordinates(coordinates);
                    componente13Model.setComponente(componente);
                    componente13Model.setEnlace_bim(enlace_bim);
                    componente13Model.setNombre(nombre);
                    componente13Model.setSector(sector);
                    componente13Model.setPaquete(paquete);
                    componente13Model.setCodigo(codigo);

                    componente13Service.upload(componente13Model);

                }


            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("No se encuentro archivo");
        }
        return "redirect:/home/show";
    }

    @PostMapping("/subir")
    public ResponseEntity<String> uplData(@RequestPart("file") MultipartFile file) {
        // Procesar el archivo
        if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();
                // Aquí puedes guardar el archivo en una variable o hacer el procesamiento que necesites
                // Por ejemplo:
                String geoJson = new String(bytes);
                System.out.println("Contenido del archivo:\n" + geoJson);

                ObjectMapper objectMapper = new ObjectMapper();
                FeatureCollection featureCollection = objectMapper.readValue(geoJson, FeatureCollection.class);

                String type = featureCollection.getType();
                String name = featureCollection.getName();
                Crs crs = featureCollection.getCrs();
                String crs_type = crs.getType();
                Properties crs_properties = crs.getProperties();
                String crs_properties_name = crs_properties.getName();


                for (Feature features : featureCollection.getFeatures()) {

                    String features_type = features.getType();
                    String geometry_type = features.getGeometry().getType();

                    List<List<List<List<Double>>>> coordinates = features.getGeometry().getCoordinates();
                    String componente = features.getProperties().getComponente();
                    String nombre = features.getProperties().getNombre();
                    String enlace_bim = features.getProperties().getEnlaceBim();
                    Double sector = (double) features.getProperties().getSector();
                    Double paquete = (double) features.getProperties().getPaquete();
                    String codigo = features.getProperties().getCodigo();

                    Componente13Model componente13Model = new Componente13Model();

                    componente13Model.setType_(type);
                    componente13Model.setName_(name);
                    componente13Model.setCrs_type(crs_type);
                    componente13Model.setCrs_properties_name(crs_properties_name);
                    componente13Model.setGeometry_type(geometry_type);

                    componente13Model.setFeatures_type(features_type);

                    componente13Model.setCoordinates(coordinates);
                    componente13Model.setComponente(componente);
                    componente13Model.setEnlace_bim(enlace_bim);
                    componente13Model.setNombre(nombre);
                    componente13Model.setSector(sector);
                    componente13Model.setPaquete(paquete);
                    componente13Model.setCodigo(codigo);

                    componente13Service.upload(componente13Model);

                }


            } catch (Exception e) {
                e.printStackTrace();
            }
            return ResponseEntity.ok("Archivo subido correctamente");
        } else {
            return ResponseEntity.badRequest().body("Archivo no válido");
        }
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/allJson")
    @ResponseBody
    public List<FeatureCollection> FindAllJson() {
        String s = null;
        List<Componente13Model> listModel = componente13Service.findAll();
        List<FeatureCollection> listFeatureCollection = new ArrayList<>();


        for (int i = 0; i < listModel.size(); i++) {
            Componente13Model componente13Model = listModel.get(i);

            ObjectMapper objectMapper = new ObjectMapper();

            FeatureCollection featureCollection = new FeatureCollection();

            featureCollection.setType(componente13Model.getType_());
            featureCollection.setName(componente13Model.getName_());

            //Ingresando datos del CRS

            Crs crs = new Crs();
            crs.setType(componente13Model.getCrs_type());
            Properties properties = new Properties();
            properties.setName(componente13Model.getCrs_properties_name());
            crs.setProperties(properties);
            featureCollection.setCrs(crs);

            //Ingresando datos de Feature

            Feature feature = new Feature();
            List<Feature> listFeature = new ArrayList<>();

            feature.setType(componente13Model.getFeatures_type());

            com.tabla.proyecto.mapJson.features.Properties featuresProperties = new com.tabla.proyecto.mapJson.features.Properties();
            featuresProperties.setId(componente13Model.getId());
            featuresProperties.setComponente(componente13Model.getComponente());
            featuresProperties.setCodigo(componente13Model.getCodigo());
            featuresProperties.setEnlaceBim(componente13Model.getEnlace_bim());
            featuresProperties.setSector(componente13Model.getSector());
            featuresProperties.setPaquete(componente13Model.getPaquete());
            featuresProperties.setNombre(componente13Model.getNombre());

            Geometry featuresGeometry = new Geometry();

            featuresGeometry.setCoordinates(componente13Model.getCoordinates());
            featuresGeometry.setType(componente13Model.getGeometry_type());

            feature.setGeometry(featuresGeometry);

            feature.setProperties(featuresProperties);

            listFeature.add(feature);

            featureCollection.setFeatures(listFeature);

            listFeatureCollection.add(featureCollection);

        }

        return listFeatureCollection;
    }


}
