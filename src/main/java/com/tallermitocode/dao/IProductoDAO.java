package com.tallermitocode.dao;

import com.tallermitocode.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductoDAO extends JpaRepository<Producto, Integer> {
}
