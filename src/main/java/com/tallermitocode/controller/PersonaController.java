package com.tallermitocode.controller;

import com.tallermitocode.exception.ModeloNotFoundException;
import com.tallermitocode.model.Persona;
import com.tallermitocode.service.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/personas")
public class PersonaController {

    @Autowired
    private IPersonaService service;

    /**
     * Se recomienda englobar las respuestas de los servicios en un ResponseEntity
     * @return
     */
    @GetMapping(produces = "application/json")
    public ResponseEntity<List<Persona>> listar(){
        List<Persona> personas = new ArrayList<>();
        personas = service.listar();
        return new ResponseEntity<List<Persona>>(personas, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public Persona listarId(@PathVariable("id") Integer id){
       Persona p = service.listarId(id);
        if(p == null){
            throw new ModeloNotFoundException("Id " + id + "No Encontrado");
        }
        return service.listarId(id);
    }

    @PostMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<Object> registrar(@RequestBody Persona persona){
        Persona per = new Persona();
        per = service.registrar(persona);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(per.getIdPersona()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<Object> modificar(@RequestBody Persona persona){
        service.modificar(persona);
        return new ResponseEntity<Object>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public void eliminar(@PathVariable("id") Integer id){
        Persona per = service.listarId(id);
        if(per == null){
            throw new ModeloNotFoundException("ID NO ENCONTRADO: " + id);
        }else{
            service.eliminar(id);
        }
    }
}
