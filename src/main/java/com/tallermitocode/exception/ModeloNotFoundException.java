package com.tallermitocode.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Execepcion personalizada, para crearla se debe heredar de RuntimeException y pasarle un mensaje
 * al constructor.
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ModeloNotFoundException extends RuntimeException{

    public ModeloNotFoundException(String mensaje){
        super(mensaje);
    }
}
