package com.janek.letsner.domain.lesson;

import com.janek.letsner.common.exceptions.ItemNotFoundException;
import com.janek.letsner.infrastructure.lesson.LessonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class LessonService {

    private final LessonRepository lessonRepository;

    @Transactional
    public void createNewLesson(Lesson lesson) {
        lessonRepository.save(lesson);
    }

    public Lesson getLessonByToken(String token) {
        return lessonRepository.findByToken(token)
            .orElseThrow(() -> new ItemNotFoundException("해당 수업 정보를 찾을 수 없습니다."));
    }

    public List<Lesson> getLessonsByUserToken(String token) {
        return lessonRepository.findAllByUserToken(token);
    }

    public void deleteLessonByToken(String token) {
        lessonRepository.delete(getLessonByToken(token));
    }

}
