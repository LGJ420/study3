package com.example.developer.dto;

import com.example.developer.domain.Article;
import com.example.developer.domain.Comment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class AddCommentRequest {
    
    private Long articleId;
    private String content;

    public Comment toEntity(String author, Article article){
        
        return Comment.builder()
            .article(article)
            .content(content)
            .author(author)
            .build();
    }
}
