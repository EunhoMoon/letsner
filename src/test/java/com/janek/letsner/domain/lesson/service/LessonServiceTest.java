package com.janek.letsner.domain.lesson.service;

import com.janek.letsner.domain.lesson.entity.Lesson;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
@Transactional(readOnly = true)
class LessonServiceTest {

    @Autowired
    LessonService lessonService;

    @Test
    @DisplayName("")
    @Transactional
    void test() {
        //given
        Lesson lesson = Lesson.builder()
                .lessonDate(LocalDate.parse("2023-03-02"))
                .lessonTime(LocalTime.parse("16:00"))
                .build();

        // when
        lessonService.save(lesson);

        // then
    }

}