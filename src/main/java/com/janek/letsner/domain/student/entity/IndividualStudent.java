package com.janek.letsner.domain.student.entity;

import com.janek.letsner.domain.student.request.StudentRegistration;
import com.janek.letsner.domain.member.entity.Member;
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

    public IndividualStudent(StudentRegistration registration, Member user) {
        super(registration, user);
    }
}
