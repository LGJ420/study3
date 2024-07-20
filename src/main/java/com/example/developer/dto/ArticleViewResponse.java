package com.example.developer.dto;

import java.time.LocalDateTime;
import java.util.*;

import com.example.developer.domain.Article;
import com.example.developer.domain.Comment;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class ArticleViewResponse {
    
    private Long id;
    private String title;
    private String content;
    private LocalDateTime createdAt;
    private String author;
    private List<Comment> comments;

    public ArticleViewResponse(Article article){
        
        this.id = article.getId();
        this.title = article.getTitle();
        this.content = article.getContent();
        this.createdAt = article.getCreatedAt();
        this.author = article.getAuthor();
        this.comments = article.getComments();
    }
}
