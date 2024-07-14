package com.example.developer.dto;

import com.example.developer.domain.Article;

import lombok.Getter;

@Getter
public class ArticleResponse {
    
    private final String title;
    private final String content;

    // 이 책은 여기선 이랬다가 저기선 저랬다가 맘대로 작성하네
    public ArticleResponse(Article article){
        
        this.title = article.getTitle();
        this.content = article.getContent();
    }
}
