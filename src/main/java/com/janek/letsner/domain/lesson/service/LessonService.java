package com.janek.letsner.domain.lesson.service;

import com.janek.letsner.domain.lesson.entity.Lesson;
import com.janek.letsner.domain.lesson.entity.LessonEditor;
import com.janek.letsner.domain.lesson.repository.LessonRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static com.janek.letsner.domain.lesson.entity.LessonEditor.*;

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
            edit(lesson);
        }
    }

    private void edit(Lesson lesson) {
        Lesson findLesson = lessonRepository.findById(lesson.getId())
                .orElseThrow(RuntimeException::new);

        LessonEditorBuilder editorBuilder = lesson.toEditor();

        LessonEditor editor = editorBuilder
                .lessonDate(lesson.getLessonDate())
                .lessonTime(lesson.getLessonTime())
                .build();

        findLesson.edit(editor);
    }


}
