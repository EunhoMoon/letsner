package com.janek.letsner.request;

import com.janek.letsner.domain.Member;
import com.janek.letsner.domain.student.PeriodType;
import com.janek.letsner.domain.student.RegistrationStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Getter
@ToString
@AllArgsConstructor
public class StudentRegistration {

    @NotBlank
    private String name;

    private LocalDate birth;

    @NotBlank
    private PeriodType periodType;

    @NotBlank
    private int pricePerPeriod;

    @NotBlank
    private Long memberId;

    private Long academyId;

}
