package com.janek.letsner.domain;

import com.janek.letsner.domain.student.AcademyStudent;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Academy {

    @Id
    @GeneratedValue
    @Column(name = "academy_id")
    private Long id;

    @Column(name = "academy_name")
    private String name;

    @OneToMany(mappedBy = "academy")
    private List<AcademyStudent> students = new ArrayList<>();

    public Academy(String name) {
        this.name = name;
    }

}
