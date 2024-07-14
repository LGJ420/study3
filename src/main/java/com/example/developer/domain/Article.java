package com.example.developer.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Article {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "content", nullable = false)
    private String content;

    @Builder
    public Article(String title, String content){

        this.title = title;
        this.content = content;
    }

    // 이책 업데이트가 엔티티에 있음 또라이임, 심지어 위에 코드랑 똑같은거 무엇..
    public void update(String title, String content){

        this.title = title;
        this.content = content;
    }
}
