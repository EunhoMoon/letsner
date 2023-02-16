package com.janek.letsner.domain.classes.entity;

import com.janek.letsner.domain.classes.LessonDay;
import com.janek.letsner.domain.member.entity.Member;
import com.janek.letsner.domain.student.entity.Student;

import javax.persistence.*;
import java.time.LocalTime;

@Entity
@Table(name = "lesson")
public class LessonSchedule {

    @Id @GeneratedValue
    @Column(name = "lesson_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @Enumerated(EnumType.STRING)
    private LessonDay lessonDate;
    private LocalTime lessonTime;

}
