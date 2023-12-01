package com.ll.demo.boundedContext.article.controller;

import com.ll.demo.base.rsData.RsData;
import com.ll.demo.boundedContext.article.entity.Article;
import com.ll.demo.boundedContext.article.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/articles")
public class ArticleController {

  private final ArticleService articleService;

  @GetMapping("")
  public List<Article> articles (){
    return articleService.findAll();
  }
}
