package com.tallermitocode.controller;

import com.tallermitocode.model.Persona;
import com.tallermitocode.service.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/personas")
public class PersonaController {

    @Autowired
    private IPersonaService service;

    @GetMapping(produces = "application/json")
    public List<Persona> listar(){
        return service.listar();
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public Persona listarId(@PathVariable("id") Integer id){
        return service.listarId(id);
    }

    @PostMapping(produces = "application/json", consumes = "application/json")
    public Persona registrar(@RequestBody Persona persona){
        return service.registrar(persona);
    }

    @PutMapping(produces = "application/json", consumes = "application/json")
    public Persona modificar(@RequestBody Persona persona){
        return service.modificar(persona);
    }

    @DeleteMapping(value = "/{id}")
    public void eliminar(@PathVariable("id") Integer id){
        service.eliminar(id);
    }
}
