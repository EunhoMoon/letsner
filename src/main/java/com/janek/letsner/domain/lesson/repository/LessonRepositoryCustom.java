package com.janek.letsner.domain.lesson.repository;

import com.janek.letsner.domain.lesson.entity.Lesson;

import java.time.LocalDate;
import java.util.List;

public interface LessonRepositoryCustom {

    long findDuplicatedLesson(Lesson searchLesson);

    List<Lesson> findLessonListAt(Long memberId, LocalDate from, LocalDate to);

}
