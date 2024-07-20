package com.example.developer.config.error.exception;

import com.example.developer.config.error.ErrorCode;

public class NotFoundException extends BusinessBaseException {

    public NotFoundException(ErrorCode errorCode) {

        super(errorCode.getMessage(), errorCode);
    }
    
    public NotFoundException() {

        super(ErrorCode.NOT_FOUND);
    }
}
