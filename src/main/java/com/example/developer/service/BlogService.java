package com.example.developer.service;

import java.util.*;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.developer.config.error.exception.ArticleNotFoundException;
import com.example.developer.domain.Article;
import com.example.developer.domain.Comment;
import com.example.developer.dto.AddArticleRequest;
import com.example.developer.dto.AddCommentRequest;
import com.example.developer.dto.UpdateArticleRequest;
import com.example.developer.repository.BlogRepository;
import com.example.developer.repository.CommentRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BlogService {
    
    private final BlogRepository blogRepository;
    private final CommentRepository commentRepository;

    public Article save(AddArticleRequest request, String userName){

        return blogRepository.save(request.toEntity(userName));
    }

    
    public List<Article> findAll(){

        return blogRepository.findAll();
    }


    public Article findById(long id){

        return blogRepository.findById(id).orElseThrow(ArticleNotFoundException::new);
    }


    public void delete(long id){

        Article article = blogRepository.findById(id).orElseThrow(()->new IllegalArgumentException("not found : " + id));

        // 5번의 강의중 이곳만 처음으로 deleteById를 쓰네;
        authorizeArticleAuthor(article);
        blogRepository.deleteById(id);
    }


    @Transactional
    public Article update(long id, UpdateArticleRequest request) {

        Article article = blogRepository.findById(id).orElseThrow(()->new IllegalArgumentException("not found: " + id));

        // 이 책의 꽃, 이 책만 수정을 이런식으로 하는데, 이게 작동된다
        // Transactional이 적용된 메서드 내에서 엔티티의 필드를 변경하면
        // 커밋될때 변경사항이 적용된다
        // 이것이 바로 Transactional!!!
        authorizeArticleAuthor(article);
        article.update(request.getTitle(), request.getContent());

        return article;
    }


    private static void authorizeArticleAuthor(Article article){

        String userName = SecurityContextHolder.getContext().getAuthentication().getName();

        if(!article.getAuthor().equals(userName)){

            throw new IllegalArgumentException("not authorized");
        }
    }

    public Comment addComment(AddCommentRequest request, String userName){
        
        Article article = blogRepository.findById(request.getArticleId())
            .orElseThrow(()->new IllegalArgumentException("not found : " + request.getArticleId()));

        return commentRepository.save(request.toEntity(userName, article));
    }

}
