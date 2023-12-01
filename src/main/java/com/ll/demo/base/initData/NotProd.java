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
      Member member2 = memberService.join("user1", "1234", "user1", "user1@test.com").getData();
      Member member3 = memberService.join("user2", "1234", "user2", "user2@test.com").getData();

      Article article1 = articleService.write(member1, "제목1", "제목1").getData();
      Article article2 = articleService.write(member1, "제목2", "제목2").getData();
      Article article3 = articleService.write(member1, "제목3", "제목3").getData();
      Article article4 = articleService.write(member1, "제목4", "제목4").getData();
      Article article5 = articleService.write(member2, "제목5", "제목5").getData();
      Article article6 = articleService.write(member2, "제목6", "제목6").getData();
      Article article7 = articleService.write(member2, "제목7", "제목7").getData();
      Article article8 = articleService.write(member2, "제목8", "제목8").getData();
      Article article9 = articleService.write(member3, "제목9", "제목9").getData();
      Article article10 = articleService.write(member3, "제목10", "제목10").getData();
    }

  }

