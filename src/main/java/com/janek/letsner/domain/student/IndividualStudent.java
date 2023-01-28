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
@DiscriminatorValue("I")
public class IndividualStudent extends Student {

    public IndividualStudent(StudentRegistration registration, Member member) {
        super(registration, member);
    }
}
