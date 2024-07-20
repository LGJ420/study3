package com.example.developer.config.error;

import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.developer.config.error.exception.BusinessBaseException;
import com.example.developer.dto.ErrorResponse;

import lombok.extern.log4j.Log4j2;

@Log4j2
@ControllerAdvice
public class GlobalExceptionHandler {
    
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    protected ResponseEntity<ErrorResponse> handle(
        HttpRequestMethodNotSupportedException e){
        
        log.error("HttpRequestMethodNotSupportedException", e);

        return createErrorResponseEntity(ErrorCode.METHOD_NOT_ALLOWED);
    }

    @ExceptionHandler(BusinessBaseException.class)
    protected ResponseEntity<ErrorResponse> handle(
        BusinessBaseException e){
        
        log.error("BusinessException", e);

        return createErrorResponseEntity(e.getErrorCode());
    }

    @ExceptionHandler(Exception.class)
    protected ResponseEntity<ErrorResponse> handle(
        Exception e){
        
        e.printStackTrace();
        log.error("Exception", e);

        return createErrorResponseEntity(ErrorCode.INTERNAL_SERVER_ERROR);
    }

    private ResponseEntity<ErrorResponse> createErrorResponseEntity(ErrorCode errorCode){

        return new ResponseEntity<>(
            ErrorResponse.of(errorCode),
            errorCode.getStatus());
        
    }
}
