package com.igac.estadisticasservidorigac.excepciones;

import com.igac.estadisticasservidorigac.dtos.ErrorDetalleDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.persistence.NonUniqueResultException;
import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorDetalleDto> HandlerNotFound(
        ResourceNotFoundException resourceNotFoundException,
        WebRequest webRequest
    ){
        return new ResponseEntity<>(new ErrorDetalleDto(
                new Date(),
                resourceNotFoundException.getMessage(),
                webRequest.getDescription(false)
        ), HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(NonUniqueResultException.class)
    public ResponseEntity<ErrorDetalleDto> handlerNonUnique(
            HandlerNonUniqueResultException handlerNonUniqueResultException,
            WebRequest webRequest
    ){
        return new ResponseEntity<>(new ErrorDetalleDto(
                new Date(),
                handlerNonUniqueResultException.getMessage(),
                webRequest.getDescription(false)
        ), HttpStatus.BAD_REQUEST);
    }


}
