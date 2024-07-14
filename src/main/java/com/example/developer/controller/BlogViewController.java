package com.example.developer.controller;

import java.util.*;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.developer.domain.Article;
import com.example.developer.dto.ArticleListViewResponse;
import com.example.developer.dto.ArticleViewResponse;
import com.example.developer.service.BlogService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class BlogViewController {
    
    private final BlogService blogService;

    @GetMapping("/articles")
    public String getArticles(Model model){

        List<ArticleListViewResponse> articles = blogService.findAll().stream()
            .map(ArticleListViewResponse::new)
            .toList();

        model.addAttribute("articles", articles);

        return "articleList";
    }


    @GetMapping("/articles/{id}")
    public String getArticle(@PathVariable Long id, Model model){

        Article article = blogService.findById(id);
        model.addAttribute("article", new ArticleViewResponse(article));

        return "article";
    }


    @GetMapping("/new-article")
    public String newArticle(@RequestParam(required = false) Long id, Model model){

        if (id == null){
            model.addAttribute("article", new ArticleViewResponse());
        }
        else{
            Article article = blogService.findById(id);
            model.addAttribute("article", new ArticleViewResponse(article));
        }

        return "newArticle";
    }
}
