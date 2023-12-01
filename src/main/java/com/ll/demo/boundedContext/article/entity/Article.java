package com.ll.demo.boundedContext.article.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ll.demo.base.baseEntity.BaseEntity;
import com.ll.demo.boundedContext.member.entity.Member;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import static jakarta.persistence.FetchType.LAZY;
import static lombok.AccessLevel.PROTECTED;

@Entity
@SuperBuilder
@AllArgsConstructor(access = PROTECTED)
@NoArgsConstructor(access = PROTECTED)
@Setter
@Getter
@ToString(callSuper = true)
public class Article extends BaseEntity {

  @ManyToOne(fetch = LAZY)
  @JsonIgnore
  private Member author;

  private String subject;

  private String content;

}
