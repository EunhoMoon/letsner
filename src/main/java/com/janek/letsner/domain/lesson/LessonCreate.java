package com.janek.letsner.domain.lesson;

import com.janek.letsner.common.utils.TokenGenerator;
import com.janek.letsner.domain.user.User;
import lombok.Builder;
import lombok.Getter;

@Getter
public class LessonCreate {

    private static final String PREFIX_LESSON = "LESSON_";

    private final String lessonToken;

    private final LessonKind kind;

    private final LessonType type;

    @Builder
    public LessonCreate(LessonKind kind, LessonType type) {
        this.lessonToken = TokenGenerator.randomCharacterWithPrefix(PREFIX_LESSON);
        this.kind = kind;
        this.type = type;
    }

    public Lesson toLesson(User user) {
        return Lesson.builder()
            .user(user)
            .build();
    }

}
