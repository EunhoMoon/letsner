package com.janek.letsner.domain.student;

import com.janek.letsner.domain.Academy;
import com.janek.letsner.domain.Member;
import com.janek.letsner.request.StudentRegistration;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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

    public AcademyStudent(StudentRegistration registration, Member member, Academy academy) {
        super(registration, member);
        setAcademy(academy);
    }

}
