package com.janek.letsner.service;

import com.janek.letsner.domain.Member;
import com.janek.letsner.domain.student.AcademyStudent;
import com.janek.letsner.domain.student.IndividualStudent;
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
    @DisplayName("학원생 등록 성공")
    void academyStudentRegistration() {
        Member member = Member.builder()
                .username("test")
                .password("1234")
                .name("테스터")
                .build();

        em.persist(member);

        StudentRegistration registration = new StudentRegistration("테스트", LocalDate.of(1992, 1, 28), PeriodType.FOUR_WEEK, 30000, member.getId(), 1L);
        Student regStudent = studentService.registration(registration);

        assertEquals(regStudent.getName(), "테스트");
        assertEquals(registration.getAcademyId(), 1L);
        assertEquals(regStudent.getMember().getUsername(), "test");
        assertEquals(regStudent.getClass(), AcademyStudent.class);
        assertNotEquals(regStudent.getClass(), IndividualStudent.class);
    }

    @Test
    @DisplayName("개인레슨생 등록 성공")
    void individualStudentRegistration() {
        Member member = Member.builder()
                .username("test")
                .password("1234")
                .name("테스터")
                .build();

        em.persist(member);

        StudentRegistration registration = new StudentRegistration("테스트", LocalDate.of(1992, 1, 28), PeriodType.FOUR_WEEK, 30000, member.getId(), null);
        Student regStudent = studentService.registration(registration);

        assertEquals(regStudent.getName(), "테스트");
        assertEquals(regStudent.getMember().getUsername(), "test");
        assertEquals(regStudent.getClass(), IndividualStudent.class);
        assertNotEquals(regStudent.getClass(), AcademyStudent.class);
    }

}