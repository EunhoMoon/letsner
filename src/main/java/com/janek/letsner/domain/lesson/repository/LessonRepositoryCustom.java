package com.janek.letsner.domain.lesson.repository;

import com.janek.letsner.domain.lesson.entity.Lesson;

public interface LessonRepositoryCustom {

    long findDuplicatedLesson(Lesson searchLesson);

}
