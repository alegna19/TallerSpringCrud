package com.tallermitocode.dao;

import com.tallermitocode.model.Venta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IVentaDAO extends JpaRepository<Venta, Integer> {
}
