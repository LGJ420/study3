package com.example.developer.dto;

import com.example.developer.domain.Article;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class AddArticleRequest {
    
    private String title;
    private String content;

    public Article toEntity(String author){

        return Article.builder().title(title).content(content).author(author).build();
    }
}
