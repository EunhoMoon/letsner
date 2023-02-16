package com.janek.letsner.domain.member.service;

import com.janek.letsner.domain.member.repository.MemberRepository;
import com.janek.letsner.domain.member.request.MemberCreate;
import com.janek.letsner.domain.member.response.MemberResponse;
import com.janek.letsner.domain.member.service.MemberService;
import com.janek.letsner.exception.MemberNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@Slf4j
@Transactional
@SpringBootTest
class MemberServiceTest {

    @Autowired
    private MemberService memberService;

    @Autowired
    private MemberRepository memberRepository;


    @Test
    @DisplayName("회원 단건 조회 실패시 UserNotFoundException 발생")
    void memberNotFoundTest() {
        assertThrows(MemberNotFoundException.class, () -> {
            memberService.findOne(10L);
        }, "회원을 찾을 수 없습니다.");
    }

    @Test
    @DisplayName("회원 가입")
    void joinTest() {
        // given
        MemberCreate memberCreate = new MemberCreate("member1", "회원1", "1234");

        // when
        MemberResponse response = memberService.join(memberCreate);

        // then
        MemberResponse memberResponse = memberService.findOne(response.getId());

        assertThat(memberRepository.count()).isEqualTo(1L);
        assertThat(memberResponse.getId()).isEqualTo(1L);
        assertThat(memberResponse.getName()).isEqualTo("회원1");
    }

    @Test
    @DisplayName("회원 전체 조회")
    void findAllTest() {
        // given
        for (int i = 1 ; i <= 10 ; i++) {
            MemberCreate userCreate = new MemberCreate("member" + i,"회원" + i, "1234" + i);
            memberService.join(userCreate);
        }

        // when
        List<MemberResponse> memberResponses = memberService.findAll();

        // then
        assertThat(memberResponses.size()).isEqualTo(10);
    }

}