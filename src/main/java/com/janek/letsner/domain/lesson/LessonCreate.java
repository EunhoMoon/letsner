package com.janek.letsner.domain.lesson;

import com.janek.letsner.common.utils.TokenGenerator;
import com.janek.letsner.domain.user.User;
import lombok.Getter;

@Getter
public class LessonCreate {

    private static final String PREFIX_LESSON = "LESSON_";

    private final String lessonToken;

    public LessonCreate() {
        this.lessonToken = TokenGenerator.randomCharacterWithPrefix(PREFIX_LESSON);
    }

    public Lesson toLesson(User user) {
        return Lesson.builder()
            .user(user)
            .build();
    }

}
