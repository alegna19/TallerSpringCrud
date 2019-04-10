package com.tallermitocode.controller;

import com.tallermitocode.model.Producto;
import com.tallermitocode.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private IProductoService service;

    @GetMapping(produces = "application/json")
    public List<Producto> listar(){
        return service.listar();
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public Producto listarId(@PathVariable("id") Integer id){
        return service.listarId(id);
    }

    @PostMapping(produces = "application/json", consumes = "application/json")
    public Producto registrar(@RequestBody Producto producto){
        return service.registrar(producto);
    }

    @PutMapping(produces = "application/json", consumes = "application/json")
    public Producto modificar(@RequestBody Producto producto){
        return service.modificar(producto);
    }

    @DeleteMapping(value = "/{id}")
    public void eliminar(@PathVariable("id") Integer id){
        service.eliminar(id);
    }
}
