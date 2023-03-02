package com.janek.letsner.domain.lesson.repository;

import com.janek.letsner.domain.lesson.entity.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface LessonRepository extends JpaRepository<Lesson, Long>, LessonRepositoryCustom {

}

