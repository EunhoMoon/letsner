package com.janek.letsner.domain.lesson;

import com.janek.letsner.common.utils.TokenGenerator;
import com.janek.letsner.domain.user.User;
import lombok.Getter;

import java.time.ZonedDateTime;

@Getter
public class LessonCreate {

    private static final String PREFIX_LESSON = "LESSON_";

    private final String lessonToken;

    private final ZonedDateTime startAt;

    private final ZonedDateTime endAt;

    public LessonCreate(ZonedDateTime startAt, ZonedDateTime endAt) {
        this.lessonToken = TokenGenerator.randomCharacterWithPrefix(PREFIX_LESSON);
        this.startAt = startAt;
        this.endAt = endAt;
    }

    public Lesson toLesson(User user) {
        return Lesson.builder()
            .startedAt(this.startAt)
            .endAt(this.endAt)
            .user(user)
            .build();
    }

}
