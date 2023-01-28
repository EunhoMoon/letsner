package com.janek.letsner.service;

import com.janek.letsner.domain.Member;
import com.janek.letsner.domain.student.AcademyStudent;
import com.janek.letsner.domain.student.IndividualStudent;
import com.janek.letsner.domain.student.Student;
import com.janek.letsner.exception.MemberNotFoundException;
import com.janek.letsner.repository.MemberRepository;
import com.janek.letsner.repository.StudentRepository;
import com.janek.letsner.request.StudentRegistration;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.janek.letsner.domain.student.RegistrationStatus.REGISTRATION;
import static java.time.LocalDate.now;

@Slf4j
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class StudentService {

    private final MemberRepository memberRepository;

    private final StudentRepository studentRepository;

    public Student registration(StudentRegistration registration) {
        Member findMember = memberRepository.findById(registration.getMemberId())
                .orElseThrow(MemberNotFoundException::new);

        Student student;

        if (registration.getAcademyId() != null) {
            student = AcademyStudent.builder()
                    .member(findMember)
                    .name(registration.getName())
                    .birth(registration.getBirth())
                    .periodType(registration.getPeriodType())
                    .pricePerPeriod(registration.getPricePerPeriod())
                    .registrationStatus(REGISTRATION)
                    .registrationDate(now())
                    .build();
        } else {
            student = IndividualStudent.builder()
                    .member(findMember)
                    .name(registration.getName())
                    .birth(registration.getBirth())
                    .periodType(registration.getPeriodType())
                    .pricePerPeriod(registration.getPricePerPeriod())
                    .registrationStatus(REGISTRATION)
                    .registrationDate(now())
                    .build();
        }

        return studentRepository.save(student);
    }

}
