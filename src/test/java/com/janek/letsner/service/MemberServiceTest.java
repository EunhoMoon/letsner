package com.janek.letsner.service;

import com.janek.letsner.domain.Member;
import com.janek.letsner.repository.MemberRepository;
import com.janek.letsner.request.MemberCreate;
import com.janek.letsner.response.MemberResponse;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@Transactional
@SpringBootTest
class MemberServiceTest {

    @Autowired
    private MemberService memberService;

    @Autowired
    private MemberRepository memberRepository;

    @Test
    @DisplayName("회원 가입")
    void join() {
        MemberCreate memberCreate = new MemberCreate("회원1", "1234");

        Member member = memberService.join(memberCreate);

        MemberResponse memberResponse = memberService.get(member.getId());

        log.info("memberResponse={}", memberResponse);

        assertThat(memberRepository.count()).isEqualTo(1L);
        assertThat(memberResponse.getId()).isEqualTo(1L);
        assertThat(memberResponse.getName()).isEqualTo("회원1");
    }

}