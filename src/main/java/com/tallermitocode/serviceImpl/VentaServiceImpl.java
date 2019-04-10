package com.tallermitocode.serviceImpl;

import com.tallermitocode.dao.IVentaDAO;
import com.tallermitocode.model.Venta;
import com.tallermitocode.service.IVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VentaServiceImpl implements IVentaService {

    @Autowired
    private IVentaDAO dao;

    @Override
    public Venta registrar(Venta venta) {
        venta.getDetalleVenta().forEach(d -> {
            d.setVenta(venta);
        });
        return dao.save(venta);
    }

    @Override
    public List<Venta> listar() {
        return dao.findAll();
    }

    @Override
    public Venta listarId(int id) {
        return dao.findOne(id);
    }

    @Override
    public Venta modificar(Venta venta) {
        return null;
    }

    @Override
    public void eliminar(int id) {

    }
}
