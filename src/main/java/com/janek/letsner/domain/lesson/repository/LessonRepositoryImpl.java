package com.janek.letsner.domain.lesson.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class LessonRepositoryImpl implements LessonRepositoryCustom {

    private final JPAQueryFactory queryFactory;


}
