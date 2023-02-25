package com.janek.letsner.domain.lesson.service;

import com.janek.letsner.domain.lesson.entity.Lesson;
import com.janek.letsner.domain.lesson.repository.LessonRepository;
import com.janek.letsner.domain.lesson.request.LessonEdit;
import com.janek.letsner.exception.LessonAlreadyExistException;
import com.janek.letsner.exception.LessonNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class LessonService {

    private final LessonRepository lessonRepository;

    @Transactional
    public void save(Lesson lesson) {
        if (lesson.getId() == null) {
            lessonRepository.save(lesson);
        } else {
            throw new LessonAlreadyExistException();
        }
    }

    private void edit(Long lessonId, LessonEdit edit) {
        Lesson findLesson = lessonRepository.findById(lessonId)
                .orElseThrow(LessonNotFoundException::new);

        findLesson.edit(edit);
    }


}
