package com.janek.letsner.domain.student.entity;

import com.janek.letsner.domain.academy.entity.Academy;
import com.janek.letsner.domain.student.request.StudentRegistration;
import com.janek.letsner.domain.member.entity.Member;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@DiscriminatorValue("A")
public class AcademyStudent extends Student {

    @ManyToOne
    @JoinColumn(name = "academy_id")
    private Academy academy;

    public void setAcademy(Academy academy) {
        this.academy = academy;
    }

    public AcademyStudent(StudentRegistration registration, Member user, Academy academy) {
        this(registration, user, academy, null);
    }

    public AcademyStudent(StudentRegistration registration, Member user, Academy academy, LocalDate createDate) {
        super(registration, user, createDate);
        setAcademy(academy);
    }

}
