package com.example.developer.service;

import java.util.*;

import org.springframework.stereotype.Service;

import com.example.developer.domain.Article;
import com.example.developer.dto.AddArticleRequest;
import com.example.developer.repository.BlogRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BlogService {
    
    private final BlogRepository blogRepository;

    public Article save(AddArticleRequest request){

        return blogRepository.save(request.toEntity());
    }

    
    public List<Article> findAll(){

        return blogRepository.findAll();
    }
}
