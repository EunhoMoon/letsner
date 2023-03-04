package com.janek.letsner.domain.lesson.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class LessonPeriodCond {

    private Long memberId;
    private LocalDate fromDate;
    private LocalDate toDate;

}
