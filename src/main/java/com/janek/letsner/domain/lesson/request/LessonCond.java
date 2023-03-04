package com.janek.letsner.domain.lesson.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@AllArgsConstructor
public class LessonCond {

    private Long memberId;
    private LocalDate lessonDate;
    private LocalTime lessonTime;

}
