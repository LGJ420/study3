package com.example.developer.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.developer.domain.Article;
import com.example.developer.dto.AddArticleRequest;
import com.example.developer.service.BlogService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class BlogApiController {
    
    private final BlogService blogService;

    @PostMapping("/api/articles")
    public ResponseEntity<Article> addArticle(
        @RequestBody AddArticleRequest request){
        
        Article savedArticle = blogService.save(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(savedArticle);
    }
}
