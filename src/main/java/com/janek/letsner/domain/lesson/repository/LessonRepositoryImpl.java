package com.janek.letsner.domain.lesson.repository;

import com.janek.letsner.domain.lesson.entity.Lesson;
import com.janek.letsner.domain.lesson.request.LessonCond;
import com.janek.letsner.domain.lesson.request.LessonPeriodCond;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.List;

import static com.janek.letsner.domain.lesson.entity.QLesson.*;

@RequiredArgsConstructor
public class LessonRepositoryImpl implements LessonRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    public long findDuplicatedLesson(LessonCond lessonCond) {
        return queryFactory.selectFrom(lesson)
                .where(lesson.member.id.eq(lessonCond.getMemberId())
                        .and(lesson.lessonDate.eq(lessonCond.getLessonDate()))
                        .and(lesson.lessonTime.eq(lessonCond.getLessonTime())))
                .stream().count();
    }

    public List<Lesson> findLessonListAt(LessonPeriodCond periodCond) {
        return queryFactory.selectFrom(lesson)
                .where(lesson.member.id.eq(periodCond.getMemberId())
                        .and(lesson.lessonDate.between(periodCond.getFromDate(), periodCond.getToDate())))
                .fetch();
    }

}
