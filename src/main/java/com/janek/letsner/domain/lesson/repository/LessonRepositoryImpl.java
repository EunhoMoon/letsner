package com.janek.letsner.domain.lesson.repository;

import com.janek.letsner.domain.lesson.entity.Lesson;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import static com.janek.letsner.domain.lesson.entity.QLesson.*;

@RequiredArgsConstructor
public class LessonRepositoryImpl implements LessonRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    public long findDuplicatedLesson(Lesson searchLesson) {
        return queryFactory.selectFrom(lesson)
                .where(lesson.member.eq(searchLesson.getMember())
                        .and(lesson.lessonDate.eq(searchLesson.getLessonDate()))
                        .and(lesson.lessonTime.eq(searchLesson.getLessonTime())))
                .stream().count();
    }

}
