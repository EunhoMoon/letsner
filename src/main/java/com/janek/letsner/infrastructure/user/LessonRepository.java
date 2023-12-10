package com.janek.letsner.infrastructure.user;

import com.janek.letsner.domain.lesson.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LessonRepository extends JpaRepository<Lesson, Long> {

    Optional<Lesson> findByToken(String token);

}
