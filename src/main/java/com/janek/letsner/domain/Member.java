package com.janek.letsner.domain;

import com.janek.letsner.domain.classes.LessonSchedule;
import com.janek.letsner.domain.student.Student;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String name;

    private String password;

    @OneToMany(mappedBy = "member")
    private List<Student> students = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    private List<LessonSchedule> schedules = new ArrayList<>();

    @Builder
    public Member(Long id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

}
