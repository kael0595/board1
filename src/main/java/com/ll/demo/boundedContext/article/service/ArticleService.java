package com.ll.demo.boundedContext.article.service;

import com.ll.demo.base.rsData.RsData;
import com.ll.demo.boundedContext.article.entity.Article;
import com.ll.demo.boundedContext.article.repository.ArticleRepository;
import com.ll.demo.boundedContext.member.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ArticleService {

  private final ArticleRepository articleRepository;

  @Transactional
  public RsData<Article> write(Member author, String title, String body) {
    Article article = Article.builder()
        .modifyDate(LocalDateTime.now())
        .author(author)
        .subject(title)
        .content(body)
        .build();

    articleRepository.save(article);

    return RsData.of("200", "%d번 게시글이 작성되었습니다.".formatted(article.getId()), article);
  }
}
