package com.janek.letsner.domain.member.entity;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class MemberTest {

    @Test
    @DisplayName("BaseEntity 상속 객체 생성시 createdDate null일 경우 정상 생성")
    void test() {
        //given
        Member member = Member.builder()
                .password("1234")
                .name("tester")
                .username("test")
                .build();

        // expect
        assertEquals(member.getCreatedDate(), LocalDate.now());
    }

    @Test
    @DisplayName("BaseEntity 상속 객체 생성시 createdDate 존재할 경우 정상 생성")
    void test2() {
        //given
        Member member = Member.builder()
                .password("1234")
                .name("tester")
                .username("test")
                .createdDate(LocalDate.parse("2022-01-28"))
                .build();

        // expect
        assertEquals(member.getCreatedDate(), LocalDate.parse("2022-01-28"));
    }

}