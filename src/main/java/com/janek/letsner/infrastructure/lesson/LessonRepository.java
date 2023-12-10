package com.janek.letsner.infrastructure.lesson;

import com.janek.letsner.domain.lesson.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LessonRepository extends JpaRepository<Lesson, Long> {

    Optional<Lesson> findByToken(String token);

    List<Lesson> findAllByUserToken(String token);

}
