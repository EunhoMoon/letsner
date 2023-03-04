package com.janek.letsner.domain.lesson.service;

import com.janek.letsner.domain.lesson.entity.Lesson;
import com.janek.letsner.domain.lesson.repository.LessonRepository;
import com.janek.letsner.domain.lesson.request.LessonEdit;
import com.janek.letsner.domain.lesson.request.LessonPeriodCond;
import com.janek.letsner.domain.member.entity.Member;
import com.janek.letsner.domain.student.PeriodType;
import com.janek.letsner.domain.student.RegistrationStatus;
import com.janek.letsner.domain.student.entity.IndividualStudent;
import com.janek.letsner.domain.student.entity.Student;
import com.janek.letsner.exception.LessonAlreadyExistException;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
@Transactional
class LessonServiceTest {
    @Autowired
    private LessonRepository lessonRepository;

    @Autowired
    LessonService lessonService;

    @Autowired
    EntityManager em;

    @BeforeEach
    void init() {
        Member member = Member.builder()
                .username("test")
                .name("테스터")
                .password("1234")
                .build();

        em.persist(member);

        IndividualStudent student = IndividualStudent.builder()
                .name("테스트")
                .registrationStatus(RegistrationStatus.REGISTRATION)
                .birth(LocalDate.now())
                .periodType(PeriodType.FOUR_WEEK)
                .pricePerPeriod(30_000)
                .member(member)
                .build();

        em.persist(student);
    }

    @Test
    @DisplayName("레슨 정상 등록")
    void test() {
        //given
        Member member = em.find(Member.class, 1L);
        Student student = em.find(Student.class, 1L);
        Lesson lesson = Lesson.builder()
                .member(member)
                .student(student)
                .lessonDate(LocalDate.parse("2023-03-02"))
                .lessonTime(LocalTime.parse("16:00"))
                .build();

        // when
        lessonService.save(lesson);

        // then
        Lesson findLesson = lessonService.getOne(lesson.getId()).get();

        assertNotNull(findLesson);
        assertEquals(findLesson.getMember(), member);
        assertEquals(findLesson.getStudent(), student);
    }

    @Test
    @DisplayName("레슨 일정이 겹치는 레슨이 존재할 경우 LessonAlreadyExistException 발생")
    void test2() {
        //given
        Member member = em.find(Member.class, 1L);
        Student student = em.find(Student.class, 1L);
        Lesson lesson = Lesson.builder()
                .member(member)
                .student(student)
                .lessonDate(LocalDate.parse("2023-03-02"))
                .lessonTime(LocalTime.parse("16:00"))
                .build();

        Lesson lesson2 = Lesson.builder()
                .member(member)
                .student(student)
                .lessonDate(LocalDate.parse("2023-03-02"))
                .lessonTime(LocalTime.parse("16:00"))
                .build();

        lessonService.save(lesson);

        // expect
        assertThrows(LessonAlreadyExistException.class, () -> {
           lessonService.save(lesson2);
        });

    }

    @Test
    @DisplayName("레슨 수정 성공")
    void test3() {
        //given
        Member member = em.find(Member.class, 1L);
        Student student = em.find(Student.class, 1L);
        Lesson lesson = Lesson.builder()
                .member(member)
                .student(student)
                .lessonDate(LocalDate.parse("2023-03-02"))
                .lessonTime(LocalTime.parse("16:00"))
                .build();

        lessonService.save(lesson);

        // when
        lessonService.edit(new LessonEdit(lesson.getId(), LocalDate.parse("2023-03-10"), LocalTime.parse("16:00")));

        // then
        log.info("lesson={}", lesson);
        assertEquals(lesson.getLessonDate(), LocalDate.parse("2023-03-10"));
    }

    @Test
    @DisplayName("기간 내 레슨 리스트 정상 반환")
    void test4() {
        Member member = em.find(Member.class, 1L);
        Student student = em.find(Student.class, 1L);

        //given
        IntStream.range(1, 10).forEach(i -> {
            lessonService.save(Lesson.builder()
                    .member(member)
                    .student(student)
                    .lessonDate(LocalDate.parse(String.format("2023-03-0%s", i)))
                    .lessonTime(LocalTime.parse("16:00"))
                    .build());
        });

        // when
        List<Lesson> lessonAt = lessonService.getLessonAt(new LessonPeriodCond(1L, LocalDate.parse("2023-03-03"), LocalDate.parse("2023-03-10")));

        assertEquals(7, lessonAt.size());
    }

}