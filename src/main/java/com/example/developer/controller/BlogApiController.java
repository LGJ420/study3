package com.example.developer.controller;

import java.util.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.developer.domain.Article;
import com.example.developer.dto.AddArticleRequest;
import com.example.developer.dto.ArticleResponse;
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


    // 뭔데 여기선 갑자기 DTO로 줄생각..? 이책 설계가 개판인것만 알아둬라..
    @GetMapping("/api/articles")
    public ResponseEntity<List<ArticleResponse>> findAllArticles(){

        List<ArticleResponse> articles = blogService.findAll()
            .stream()
            .map(ArticleResponse::new)
            .toList();

        return ResponseEntity.ok().body(articles);
    }
}
