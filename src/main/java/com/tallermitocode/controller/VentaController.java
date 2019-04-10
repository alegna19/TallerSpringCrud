package com.tallermitocode.controller;

import com.tallermitocode.model.Venta;
import com.tallermitocode.service.IVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ventas")
public class VentaController {

    @Autowired
    private IVentaService service;

    @GetMapping(produces = "application/json")
    public List<Venta> listar(){
        return service.listar();
    }

    @GetMapping(value = "{/id}",produces = "application/json")
    public Venta listarID(@PathVariable("id") Integer id){
        return service.listarId(id);
    }

    @PostMapping(produces = "application/json", consumes = "application/json")
    public Venta registrar(@RequestBody Venta venta){
        return service.registrar(venta);
    }

}
