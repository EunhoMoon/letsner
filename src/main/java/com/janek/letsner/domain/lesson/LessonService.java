package com.janek.letsner.domain.lesson;

import com.janek.letsner.common.exceptions.ItemNotFoundException;
import com.janek.letsner.infrastructure.user.LessonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    public void deleteLessonByToken(String token) {
        lessonRepository.delete(getLessonByToken(token));
    }

}
