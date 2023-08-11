package com.blackcode.agenda_api.controllers.exceptions;

import com.blackcode.agenda_api.services.exceptions.RecursoNotFound;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(RecursoNotFound.class)
    public ResponseEntity<StandardError> recursoNotFound(RecursoNotFound ex, HttpServletRequest req) {
        var status = HttpStatus.NOT_FOUND.value();
        var error = new StandardError(status, Instant.now(), ex.getMessage(), "Contato não encontrado", req.getRequestURI());

        return ResponseEntity.status(status).body(error);
    }

}
