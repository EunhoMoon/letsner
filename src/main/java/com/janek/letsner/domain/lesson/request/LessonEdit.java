package com.janek.letsner.domain.lesson.request;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@ToString
public class LessonEdit {

    private final Long lessonId;
    private final LocalDate lessonDate;
    private final LocalTime lessonTime;

    @Builder
    public LessonEdit(Long lessonId, LocalDate lessonDate, LocalTime lessonTime) {
        this.lessonId = lessonId;
        this.lessonDate = lessonDate;
        this.lessonTime = lessonTime;
    }

}
