package com.ll.demo.base.initData;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
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

  public ApplicationRunner initNodProd(){
    return args -> {
      self.work1();
    };
    }

    @Transactional
    public void work1(){
      Member member1 = memberService.join("admin", "1234", "관리자", "admin@test.com").getData();

      Article article = articleService.write(member1, "제목1", "제목2");
    }

  }

