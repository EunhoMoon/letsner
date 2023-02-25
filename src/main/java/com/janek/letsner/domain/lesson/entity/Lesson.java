package com.janek.letsner.domain.lesson.entity;

import com.janek.letsner.domain.member.entity.Member;
import com.janek.letsner.domain.student.entity.Student;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Getter
@Table(name = "lesson")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Lesson {

    @Id @GeneratedValue
    @Column(name = "lesson_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    private LocalDate lessonDate;
    private LocalTime lessonTime;

    @Builder
    public Lesson(Member member, Student student, LocalDate lessonDate, LocalTime lessonTime) {
        this.member = member;
        this.student = student;
        this.lessonDate = lessonDate;
        this.lessonTime = lessonTime;
    }

    public LessonEditor.LessonEditorBuilder toEditor() {
        return LessonEditor.builder()
                .lessonDate(this.lessonDate)
                .lessonTime(this.lessonTime);
    }

    public void edit(LessonEditor editor) {
        this.lessonDate = lessonDate;
        this.lessonTime = lessonTime;
    }

}
