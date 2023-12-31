package com.janek.letsner.domain.lesson;

import com.janek.letsner.common.baseobject.BaseEntity;
import com.janek.letsner.common.utils.TokenGenerator;
import com.janek.letsner.domain.student.Student;
import com.janek.letsner.domain.user.User;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;

@Getter
@Entity
@Table(name = "lessons")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Lesson extends BaseEntity {

    private static final String PREFIX_LESSON = "LESSON";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, name = "lesson_token")
    private String token;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @Enumerated(EnumType.STRING)
    private LessonKind kind;

    @Enumerated(EnumType.STRING)
    private LessonType type;

    @Builder
    private Lesson(
        User user
    ) {
        this.token = TokenGenerator.getTokenWithPrefix(PREFIX_LESSON);
        this.user = user;
    }

}
