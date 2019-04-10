package com.tallermitocode.dao;

import com.tallermitocode.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPersonaDAO extends JpaRepository<Persona, Integer> {
}
