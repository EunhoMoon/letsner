package com.janek.letsner.domain.academy.entity;

import com.janek.letsner.domain.BaseEntity;
import com.janek.letsner.domain.student.entity.AcademyStudent;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Academy extends BaseEntity {

    @Id
    @GeneratedValue
    @Column(name = "academy_id")
    private Long id;

    @Column(name = "academy_name")
    private String name;

    @OneToMany(mappedBy = "academy")
    private List<AcademyStudent> students = new ArrayList<>();

    public Academy(String name) {
        this(name, null);
    }

    public Academy(String name, LocalDate createdDate) {
        super(createdDate);
        this.name = name;
    }

}
