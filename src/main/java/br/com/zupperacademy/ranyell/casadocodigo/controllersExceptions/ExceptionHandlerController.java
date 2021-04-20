package br.com.zupperacademy.ranyell.casadocodigo.controllersExceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ExceptionHandlerController {


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ValidationError>> validation(MethodArgumentNotValidException e) {
        List<ValidationError> list = new ArrayList<>();
        for(FieldError f : e.getBindingResult().getFieldErrors()) {
            list.add(new ValidationError(f.getField(),f.getDefaultMessage()));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(list);
    }
}
