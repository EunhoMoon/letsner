package com.janek.letsner.domain.student;

import com.janek.letsner.domain.Member;
import com.janek.letsner.request.StudentRegistration;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@DiscriminatorValue("A")
public class AcademyStudent extends Student {

    private Long academyId;

    public void setAcademy(Long academyId) {
        this.academyId = academyId;
    }

    public AcademyStudent(StudentRegistration registration, Member member) {
        super(registration, member);
    }

}
