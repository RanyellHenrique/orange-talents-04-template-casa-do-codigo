package br.com.zupperacademy.ranyell.casadocodigo.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
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

    @Autowired
    private MessageSource messageSource;

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ValidationError>> validation(MethodArgumentNotValidException e) {
        List<ValidationError> list = new ArrayList<>();
        for(FieldError f : e.getBindingResult().getFieldErrors()) {
            String mensagem = messageSource.getMessage(f, LocaleContextHolder.getLocale());
            list.add(new ValidationError(f.getField(), mensagem));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(list);
    }
}
