package com.tallermitocode.serviceImpl;

import com.tallermitocode.dao.IProductoDAO;
import com.tallermitocode.model.Producto;
import com.tallermitocode.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServiceImpl implements IProductoService {

    @Autowired
    private IProductoDAO dao;

    @Override
    public Producto registrar(Producto producto) {
        return dao.save(producto);
    }

    @Override
    public Producto modificar(Producto producto) {
        return dao.save(producto);
    }

    @Override
    public void eliminar(int id) {
        dao.delete(id);
    }

    @Override
    public List<Producto> listar() {
        return dao.findAll();
    }

    @Override
    public Producto listarId(int id) {
        return dao.findOne(id);
    }
}
