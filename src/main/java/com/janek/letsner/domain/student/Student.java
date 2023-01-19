package com.janek.letsner.domain.student;

import com.janek.letsner.domain.Member;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@DiscriminatorColumn(name = "student_type")
public abstract class Student {

    @Id @GeneratedValue
    @Column(name = "student_id")
    private Long id;

    @NotBlank
    private String name;

    private LocalDate birth;

    @Enumerated(EnumType.STRING)
    private PeriodType periodType;

    private int pricePerPeriod;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    private LocalDate registrationDate;
    private LocalDate registrationEndDate;

    @Enumerated(EnumType.STRING)
    private RegistrationStatus registrationStatus;

}
