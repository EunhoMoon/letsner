package com.janek.letsner.domain.student;

import com.janek.letsner.domain.Member;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@DiscriminatorColumn(name = "student_type")
@ToString
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

    public Student(Long id, String name, LocalDate birth, PeriodType periodType, int pricePerPeriod, Member member, LocalDate registrationDate, LocalDate registrationEndDate, RegistrationStatus registrationStatus) {
        this.id = id;
        this.name = name;
        this.birth = birth;
        this.periodType = periodType;
        this.pricePerPeriod = pricePerPeriod;
        this.member = member;
        this.registrationDate = registrationDate;
        this.registrationEndDate = registrationEndDate;
        this.registrationStatus = registrationStatus;
    }
}
