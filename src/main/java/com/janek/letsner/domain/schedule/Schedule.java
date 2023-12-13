package com.janek.letsner.domain.schedule;

import com.janek.letsner.common.baseobject.BaseEntity;
import com.janek.letsner.domain.lesson.Lesson;
import com.janek.letsner.domain.user.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;

@Getter
@Entity
@Table(name = "schedules")
@NoArgsConstructor(access = lombok.AccessLevel.PROTECTED)
public class Schedule extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "lesson_id")
    private Lesson lesson;

    private ZonedDateTime startedAt;

    private ZonedDateTime endAt;

}
