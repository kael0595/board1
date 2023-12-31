package com.ll.demo.boundedContext.article.repository;

import com.ll.demo.boundedContext.article.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {
}
