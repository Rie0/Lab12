package org.twspring.lab12.Advice;

import org.hibernate.tool.schema.spi.CommandAcceptanceException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.resource.NoResourceFoundException;
import org.twspring.lab12.Api.ApiException;

import java.sql.SQLSyntaxErrorException;

@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(value = HttpRequestMethodNotSupportedException.class)
    public ResponseEntity HttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e){
        String message= e.getMessage();
        return ResponseEntity.status(400).body(message);
    }

   @ExceptionHandler(value = ApiException.class)
    public ResponseEntity ApiException(ApiException e){
        String message= e.getMessage();
        return ResponseEntity.status(400).body(message);
    }

    @ExceptionHandler(value = NoResourceFoundException.class)
    public ResponseEntity NoResourceFoundException(NoResourceFoundException e){
        String message= e.getMessage();
        return ResponseEntity.status(404).body(message);
    }

    @ExceptionHandler(value = MethodArgumentTypeMismatchException.class)
    public ResponseEntity MethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException e){
        String message= e.getMessage();
        return ResponseEntity.status(400).body(message);
    }
   @ExceptionHandler(value = MissingPathVariableException.class)
    public ResponseEntity MissingPathVariableException(MissingPathVariableException e){
        String message= e.getMessage();
        return ResponseEntity.status(400).body(message);
    }

    @ExceptionHandler(value = DataIntegrityViolationException.class)
    public ResponseEntity DataIntegrityViolationException(DataIntegrityViolationException e){
        String message= e.getMessage();
        return ResponseEntity.status(400).body(message);
    }

   @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity MethodArgumentNotValidException(MethodArgumentNotValidException e){
        String message= e.getMessage();
        return ResponseEntity.status(400).body(message);
    }

    @ExceptionHandler(value = HttpMessageNotReadableException.class)
    public ResponseEntity HttpMessageNotReadableException(HttpMessageNotReadableException e){
        String message= e.getMessage();
        return ResponseEntity.status(400).body(message);
    }

   @ExceptionHandler(value = NullPointerException.class)
    public ResponseEntity NullPointerException(NullPointerException e){
        String message= e.getMessage();
        return ResponseEntity.status(400).body(message);
    }

   @ExceptionHandler(value = InvalidDataAccessApiUsageException.class)
    public ResponseEntity InvalidDataAccessApiUsageException(InvalidDataAccessApiUsageException e){
        String message= e.getMessage();
        return ResponseEntity.status(400).body(message);
    }

    @ExceptionHandler(value = CommandAcceptanceException.class)
    public ResponseEntity CommandAcceptanceException(CommandAcceptanceException e){
        String message= e.getMessage();
        return ResponseEntity.status(400).body(message);

    }

    @ExceptionHandler(value = SQLSyntaxErrorException.class)
    public ResponseEntity SQLSyntaxErrorException(SQLSyntaxErrorException e){
        String message= e.getMessage();
        return ResponseEntity.status(400).body(message);
    }
}
