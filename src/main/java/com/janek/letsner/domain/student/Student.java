package com.janek.letsner.domain.student;

import com.janek.letsner.domain.Member;
import com.janek.letsner.request.StudentRegistration;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

import static com.janek.letsner.domain.student.RegistrationStatus.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@DiscriminatorColumn(name = "student_type")
@AllArgsConstructor
@ToString
@Getter
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

    public Student(StudentRegistration registration, Member member) {
        this.name = registration.getName();
        this.birth = registration.getBirth();
        this.periodType = registration.getPeriodType();
        this.pricePerPeriod = registration.getPricePerPeriod();
        this.member = member;
        this.registrationDate = LocalDate.now();
        this.registrationStatus = REGISTRATION;
    }

}
