package com.janek.letsner.api.lesson;

import com.janek.letsner.common.utils.TokenGenerator;
import com.janek.letsner.domain.lesson.Lesson;
import com.janek.letsner.domain.lesson.LessonKind;
import com.janek.letsner.domain.lesson.LessonType;
import com.janek.letsner.domain.user.User;

public class LessonDto {

    public record Create(LessonKind kind, LessonType type) {

        private static final String PREFIX_LESSON = "LESSON";

        public Lesson toLesson(User user) {
            return Lesson.builder()
                .token(TokenGenerator.randomCharacterWithPrefix(PREFIX_LESSON))
                .user(user)
                .build();
        }
    }
}
