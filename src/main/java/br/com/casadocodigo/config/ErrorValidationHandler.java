package br.com.casadocodigo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ErrorValidationHandler {

    @Autowired
    private MessageSource messageSource;

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public List<ErrorRequest> handle(MethodArgumentNotValidException exception){
        List<ErrorRequest> requests = new ArrayList<>();

        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
        fieldErrors.forEach(e -> {
           String message = messageSource.getMessage(e, LocaleContextHolder.getLocale());
           ErrorRequest erro = new ErrorRequest(e.getField(), message);
           requests.add(erro);
       });

        List<ObjectError> globalErrors =exception.getBindingResult().getGlobalErrors();
        globalErrors.forEach(e ->{
            String message = messageSource.getMessage(e, LocaleContextHolder.getLocale());
            ErrorRequest erro = new ErrorRequest(e.getObjectName(), message);
            requests.add(erro);
        });


        return requests;
    }
}
