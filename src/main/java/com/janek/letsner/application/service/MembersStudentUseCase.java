package com.janek.letsner.application.service;

import com.janek.letsner.domain.academy.entity.Academy;
import com.janek.letsner.domain.academy.repository.AcademyRepository;
import com.janek.letsner.domain.member.entity.Member;
import com.janek.letsner.domain.member.repository.MemberRepository;
import com.janek.letsner.domain.student.entity.AcademyStudent;
import com.janek.letsner.domain.student.entity.IndividualStudent;
import com.janek.letsner.domain.student.entity.Student;
import com.janek.letsner.domain.student.request.StudentRegistration;
import com.janek.letsner.domain.student.service.StudentService;
import com.janek.letsner.exception.AcademyNotFoundException;
import com.janek.letsner.exception.MemberNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MembersStudentUseCase {

    private final MemberRepository memberRepository;

    private final AcademyRepository academyRepository;

    private final StudentService studentService;

    public Student registration(StudentRegistration registration) {
        Member findMember = memberRepository.findById(registration.getMemberId())
                .orElseThrow(MemberNotFoundException::new);

        Student student;

        if (registration.getAcademyId() != null) {
            Academy academy = academyRepository.findById(registration.getAcademyId()).orElseThrow(AcademyNotFoundException::new);
            student = new AcademyStudent(registration, findMember, academy);
        } else {
            student = new IndividualStudent(registration, findMember);
        }

        return studentService.registration(student);
    }

}
