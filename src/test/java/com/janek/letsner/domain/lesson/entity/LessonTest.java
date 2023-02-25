package com.janek.letsner.domain.lesson.entity;

import com.janek.letsner.domain.lesson.request.LessonEdit;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

class LessonTest {

    @Test
    @DisplayName("LessonEdit으로 수정 정상 동작")
    void test() {
        //given
        Lesson lesson = Lesson.builder()
                .lessonDate(LocalDate.parse("2023-03-02"))
                .lessonTime(LocalTime.parse("16:00"))
                .build();

        LessonEdit edit = LessonEdit.builder()
                .lessonDate(LocalDate.parse("2023-03-03"))
                .lessonTime(LocalTime.parse("15:00"))
                .build();

        // when
        lesson.edit(edit);

        // then
        assertEquals(LocalDate.parse("2023-03-03"), lesson.getLessonDate());
        assertEquals(LocalTime.parse("15:00"), lesson.getLessonTime());
    }

}