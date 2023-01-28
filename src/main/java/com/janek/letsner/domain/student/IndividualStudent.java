package com.janek.letsner.domain.student;

import com.janek.letsner.domain.Member;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@DiscriminatorValue("I")
public class IndividualStudent extends Student {

    @Builder
    public IndividualStudent(Long id, String name, LocalDate birth, PeriodType periodType, int pricePerPeriod, Member member, LocalDate registrationDate, LocalDate registrationEndDate, RegistrationStatus registrationStatus) {
        super(id, name, birth, periodType, pricePerPeriod, member, registrationDate, registrationEndDate, registrationStatus);
    }
}
