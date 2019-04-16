package com.tallermitocode.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

/**
 * Servicio Rest para el manejo de excepciones, en vez de crear un try-catch dentro del controller para
 * cada método se unsa un manejador de excepciones global.
 */

@ControllerAdvice //Anotacion transversal, escanea todas las excepciones en los paqtes que se trabajan.
@RestController
public class ResponseExceptionHandler extends ResponseEntityExceptionHandler{

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> manejarTodasLasExcepciones(Exception ex, WebRequest request){
        ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<Object>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }


    /**
     * Toda excepcion que sea de tipo ModeloNotFoundException se le va a dar
     * la estructura de fecha, mensaje y descripción del pojo creado ExceptionResponse
     * @param ex
     * @param request
     * @return
     */

    @ExceptionHandler(ModeloNotFoundException.class)
    public ResponseEntity<Object> manejadorModeloExcepciones(ModeloNotFoundException ex, WebRequest request){
        ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<Object>(exceptionResponse, HttpStatus.NOT_FOUND);
    }

    /**
     * Cuando encuentra alguna excepcion de tipo de argumentos no validos, definimos el pojo como respuesta,
     * para mostrar la fecha, el mensaje
     * y la descripcion.
     * @param ex
     * @param httpHeaders
     * @param status
     * @param request
     * @return
     */

    @Override
    public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders httpHeaders, HttpStatus status, WebRequest request){

        String errores = "";
        for(ObjectError e : ex.getBindingResult().getAllErrors()){
            errores += e.getObjectName();
        }

        // ex.getBindingResult().getAllErrors().forEach(e -> e.getObjectName();

        ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), "Validación Fallida", errores);
        return new ResponseEntity<Object>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }
}
