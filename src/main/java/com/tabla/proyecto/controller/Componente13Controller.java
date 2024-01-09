package com.tabla.proyecto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.tabla.proyecto.model.Componente13Model;
import com.tabla.proyecto.service.Componente13Service;

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
    
    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("componentes", new Componente13Model());
        return "componentesForm";
    }
    
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("componentes", componente13Service.findById(id));
        return "componentesForm";
    }
    
    @PostMapping("/save")
    public String guardar(@ModelAttribute("componentes") Componente13Model model) {
    	componente13Service.save(model);
        return "redirect:/home/show";
    }
    
    @GetMapping("/del/{id}")
    public String delete(@PathVariable Long id) {
    	componente13Service.deleteById(id);
        return "redirect:/home/show";
    }

}
