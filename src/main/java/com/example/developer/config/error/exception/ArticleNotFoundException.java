package com.example.developer.config.error.exception;

import com.example.developer.config.error.ErrorCode;

public class ArticleNotFoundException extends NotFoundException {
    
    public ArticleNotFoundException(){

        super(ErrorCode.ARTICLE_NOT_FOUND);
    }
}
