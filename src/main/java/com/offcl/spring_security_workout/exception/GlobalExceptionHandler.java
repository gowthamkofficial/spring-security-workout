package com.offcl.spring_security_workout.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.offcl.spring_security_workout.common.enums.ResponseStatus;
import com.offcl.spring_security_workout.common.response.ApiResponse;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

    // 🔹 Catch-all exception
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<?>> handleGeneralExceptions(Exception ex) {
        ApiResponse<?> response = ApiResponse.builder()
                .status(ResponseStatus.Failure)
                .message(ex.getMessage())
                .data(null)
                .build();

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }
    
    
    // 🔹 Validation errors (400)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse<Map<String, Object>>> handleValidationErrors(MethodArgumentNotValidException ex) {
        Map<String, Object> errors = new LinkedHashMap();

        ex.getFieldErrors().forEach(err -> {
            errors.put(err.getField(), err.getDefaultMessage());
        });

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ApiResponse<>(ResponseStatus.Failure, "Validation Failed", errors));
    }
    
    @ExceptionHandler(AlreadyExistsException.class)
     public ResponseEntity<ApiResponse<String>> handleAlreadyExistsException(AlreadyExistsException ex){
    	
    	return ResponseEntity.status(HttpStatus.CONFLICT).body(new ApiResponse<>(ResponseStatus.Failure,ex.getMessage(),null));
    }
    
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ApiResponse<String>> handleNotFoundException(NotFoundException ex){
   	
   	return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse<>(ResponseStatus.Failure,ex.getMessage(),null));
   }
}
