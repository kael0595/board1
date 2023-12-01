package com.ll.demo.boundedContext.member.service;

import com.ll.demo.base.rsData.RsData;
import com.ll.demo.boundedContext.member.entity.Member;
import com.ll.demo.boundedContext.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.awt.datatransfer.Clipboard;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {

  private final MemberRepository memberRepository;

  private final PasswordEncoder passwordEncoder;

  @Transactional
  public RsData<Member> join(String username, String password, String nickname, String email) {
    Member member = Member.builder()
        .modifyDate(LocalDateTime.now())
        .username(username)
        .password(passwordEncoder.encode(password))
        .nickname(nickname)
        .email(email)
        .build();

    memberRepository.save(member);

    return RsData.of("200", "%s님 가입을 환영합니다.".formatted(username), member);
  }

  public Optional<Member> findById(long id){
        return memberRepository.findById(id);
  }

  public long count(){
    return memberRepository.count();
  }
}
