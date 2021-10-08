package com.springrest.springrest.exception;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	
	@Value(value ="${data.exception.message1}")
	private String message1;
	
	@Value(value ="${data.exception.message2}")
	private String message2;
	
	@Value(value ="${data.exception.message3}")
	private String message3;
	
	
	@ExceptionHandler(value = EmployeesDataNotFoundException.class)
	public ResponseEntity<Object> employeesDataNotFoundException(EmployeesDataNotFoundException employeesDataNotFoundException) {
		
		return new ResponseEntity<>(message1, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	 public ResponseEntity<Object> numberFormatException(Exception exception) {
		
		 String name = exception.getClass().getSimpleName();
		 String type = exception.getLocalizedMessage();
		 Object value = exception.getClass().getDeclaringClass();
		
		 
		 String message = String.format("'%s' should be a valid '%s' and '%s' isnt", 
		                                   name, type, value);
		
	     return new ResponseEntity<>(message, HttpStatus.INTERNAL_SERVER_ERROR);
	  }

	 @ExceptionHandler(value = Exception.class)
	 public ResponseEntity<Object> databaseConnectionFailsException(Exception exception) {		 
	     return new ResponseEntity<>(message2, HttpStatus.INTERNAL_SERVER_ERROR);
	  }
	 
	 
	
	
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatus status, WebRequest request) {


        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", new Date());
        body.put("status", status.value());

        //Get all errors
        List<String> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(x -> x.getDefaultMessage())
                .collect(Collectors.toList());

        body.put("errors", errors);

        return new ResponseEntity<>(body, headers, status);

    }
    
    
	
	

	
}
