package com.janek.letsner.domain.student.service;

import com.janek.letsner.domain.member.entity.Member;
import com.janek.letsner.domain.student.PeriodType;
import com.janek.letsner.domain.student.RegistrationStatus;
import com.janek.letsner.domain.student.entity.IndividualStudent;
import com.janek.letsner.domain.student.entity.Student;
import com.janek.letsner.domain.student.repository.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.IntStream;

@Slf4j
@Transactional
@SpringBootTest
class StudentServiceTest {

    @Autowired
    StudentService studentService;

    @Autowired
    EntityManager em;

    @Autowired
    StudentRepository studentRepository;

    @AfterEach
    void deleteAll() {
        studentRepository.deleteAll();
    }

    @Test
    @DisplayName("회원 아이디로 학생 리스트 출력")
    void test() {
        //given
        Member member = Member.builder()
                .username("test")
                .name("테스터")
                .password("1234")
                .build();

        em.persist(member);

        IntStream.range(0, 10).forEach(i -> studentService.registration(IndividualStudent.builder()
                        .member(member)
                        .birth(LocalDate.now())
                        .periodType(PeriodType.WEEKLY)
                        .pricePerPeriod(10_000)
                        .registrationDate(LocalDate.now())
                        .registrationStatus(RegistrationStatus.REGISTRATION)
                        .name("테스트" + i)
                .build()));

        // when
        List<Student> studentList = studentService.getStudentList(member.getId());

        // then
        for (Student student : studentList) {
            log.info("student = {}", student);
        }
    }


}