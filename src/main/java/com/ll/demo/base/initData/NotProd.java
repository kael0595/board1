package com.ll.demo.base.initData;

import com.ll.demo.boundedContext.article.entity.Article;
import com.ll.demo.boundedContext.article.service.ArticleService;
import com.ll.demo.boundedContext.member.entity.Member;
import com.ll.demo.boundedContext.member.service.MemberService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
@RequiredArgsConstructor
public class NotProd {

  @Autowired
  @Lazy
  private NotProd self;

  private final MemberService memberService;

  private final ArticleService articleService;

  @Bean
  public ApplicationRunner initNodProd(){
    return args -> {
      self.work1();
    };
  }

    @Transactional
    public void work1(){

    if (memberService.count() > 0) return;


      Member member1 = memberService.join("admin", "1234", "관리자", "admin@test.com").getData();

      Article article1 = articleService.write(member1, "제목1", "제목2").getData();
    }

  }

