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

import java.util.Optional;

@Slf4j
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class LessonService {

    private final LessonRepository lessonRepository;

    public Optional<Lesson> getOne(Long lessonId) {
        return lessonRepository.findById(lessonId);
    }

    @Transactional
    public void save(Lesson lesson) {
        long dupCount = lessonRepository.findDuplicatedLesson(lesson);
        if (dupCount == 0) {
            lessonRepository.save(lesson);
        } else {
            throw new LessonAlreadyExistException();
        }
    }

    @Transactional
    public void edit(Long lessonId, LessonEdit edit) {
        Lesson findLesson = lessonRepository.findById(lessonId)
                .orElseThrow(LessonNotFoundException::new);

        findLesson.edit(edit);
    }


}
