package com.tallermitocode.serviceImpl;

import com.tallermitocode.dao.IPersonaDAO;
import com.tallermitocode.model.Persona;
import com.tallermitocode.service.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaServiceImpl implements IPersonaService {

    @Autowired
    private IPersonaDAO dao;

    @Override
    public Persona registrar(Persona persona) {
        return dao.save(persona);
    }

    @Override
    public Persona modificar(Persona persona) {
        return dao.save(persona);
    }

    @Override
    public void eliminar(int id) {
        dao.delete(id);
    }

    @Override
    public List<Persona> listar() {
        return dao.findAll();
    }

    @Override
    public Persona listarId(int id) {
        return dao.findOne(id);
    }
}
