package com.janek.letsner.domain.lesson;

import com.janek.letsner.common.baseobject.BaseEntity;
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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, name = "lesson_token")
    private String token;

    private ZonedDateTime startedAt;

    private ZonedDateTime endAt;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Builder
    private Lesson(
        String token,
        ZonedDateTime startedAt,
        ZonedDateTime endAt,
        User user
    ) {
        this.token = token;
        this.startedAt = startedAt;
        this.endAt = endAt;
        this.user = user;
    }

}
