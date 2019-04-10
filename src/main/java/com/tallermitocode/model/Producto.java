package com.tallermitocode.model;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "producto")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProducto;

    @Size(min = 3, message = "Nombre debe tener minimo 3 caracteres")
    @Column(name = "nombre", nullable = false, length = 70)
    private String nombre;

    @Size(min = 3, message = "Mensaje debe tener minimo 3 caracteres")
    @Column(name = "marca", nullable = false, length = 70)
    private String marca;

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
}
