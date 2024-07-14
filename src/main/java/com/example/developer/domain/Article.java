package com.example.developer.domain;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.*;
import lombok.*;

@EntityListeners(AuditingEntityListener.class)
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

    @CreatedDate
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

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
