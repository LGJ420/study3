package com.example.developer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.developer.domain.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long>{
    
}
