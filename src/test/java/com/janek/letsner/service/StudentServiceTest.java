package com.janek.letsner.service;

import com.janek.letsner.domain.Member;
import com.janek.letsner.domain.student.PeriodType;
import com.janek.letsner.domain.student.Student;
import com.janek.letsner.exception.MemberNotFoundException;
import com.janek.letsner.request.StudentRegistration;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@Transactional
@SpringBootTest
@Rollback(value = false)
class StudentServiceTest {

    @Autowired
    EntityManager em;

    @Autowired
    StudentService studentService;

    @Test
    @DisplayName("학생 등록시 memberId가 없으면 MemberNotFoundException 발생")
    void memberNotFoundTest() {
        StudentRegistration registration = new StudentRegistration("테스트", LocalDate.of(1992, 1, 28), PeriodType.FOUR_WEEK, 30000, 1L, 1L);

        assertThrows(MemberNotFoundException.class, () -> studentService.registration(registration));
    }

    @Test
    @DisplayName("학생 등록 성공")
    void studentRegistration() {
        Member member = Member.builder()
                .username("test")
                .password("1234")
                .name("테스터")
                .build();

        em.persist(member);

        StudentRegistration registration = new StudentRegistration("테스트", LocalDate.of(1992, 1, 28), PeriodType.FOUR_WEEK, 30000, member.getId(), 1L);
        Student registration1 = studentService.registration(registration);

        log.info("registration1 = {}", registration1);
    }

}