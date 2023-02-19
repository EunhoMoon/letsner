package com.janek.letsner.domain.student.entity;

import com.janek.letsner.domain.student.PeriodType;
import com.janek.letsner.domain.student.RegistrationStatus;
import com.janek.letsner.domain.student.request.StudentRegistration;
import com.janek.letsner.domain.member.entity.Member;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@DiscriminatorValue("I")
public class IndividualStudent extends Student {

    public IndividualStudent(StudentRegistration registration, Member user) {
        this(registration, user, null);
    }

    public IndividualStudent(StudentRegistration registration, Member user, LocalDate createdDate) {
        super(registration, user, createdDate);
    }

    @Builder
    public IndividualStudent(Long id, @NotBlank String name, LocalDate birth, PeriodType periodType, int pricePerPeriod, Member member, LocalDate registrationDate, LocalDate registrationEndDate, RegistrationStatus registrationStatus) {
        super(id, name, birth, periodType, pricePerPeriod, member, registrationDate, registrationEndDate, registrationStatus);
    }

}
