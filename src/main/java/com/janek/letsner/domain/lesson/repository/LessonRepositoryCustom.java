package com.janek.letsner.domain.lesson.repository;

import com.janek.letsner.domain.lesson.entity.Lesson;
import com.janek.letsner.domain.lesson.request.LessonCond;
import com.janek.letsner.domain.lesson.request.LessonPeriodCond;

import java.time.LocalDate;
import java.util.List;

public interface LessonRepositoryCustom {

    long findDuplicatedLesson(LessonCond lessonFind);

    List<Lesson> findLessonListAt(LessonPeriodCond periodCond);

}
