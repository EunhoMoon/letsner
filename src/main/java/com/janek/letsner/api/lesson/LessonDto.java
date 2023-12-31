package com.janek.letsner.api.lesson;

import com.janek.letsner.domain.lesson.Lesson;
import com.janek.letsner.domain.lesson.LessonKind;
import com.janek.letsner.domain.lesson.LessonType;
import com.janek.letsner.domain.user.User;

public class LessonDto {

    public record Create(LessonKind kind, LessonType type) {

        public Lesson toLesson(User user) {
            return Lesson.builder()
                .user(user)
                .build();
        }
    }
}
