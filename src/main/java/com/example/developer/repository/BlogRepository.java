package com.example.developer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.developer.domain.Article;

public interface BlogRepository extends JpaRepository<Article, Long>{

}
