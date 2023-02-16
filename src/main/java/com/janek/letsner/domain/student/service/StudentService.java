package com.janek.letsner.domain.student.service;

import com.janek.letsner.domain.academy.entity.Academy;
import com.janek.letsner.domain.student.repository.StudentRepository;
import com.janek.letsner.domain.student.entity.AcademyStudent;
import com.janek.letsner.domain.student.entity.IndividualStudent;
import com.janek.letsner.domain.student.entity.Student;
import com.janek.letsner.domain.member.entity.Member;
import com.janek.letsner.exception.MemberNotFoundException;
import com.janek.letsner.domain.academy.repository.AcademyRepository;
import com.janek.letsner.domain.member.repository.MemberRepository;
import com.janek.letsner.domain.student.request.StudentRegistration;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class StudentService {

    private final MemberRepository memberRepository;

    private final StudentRepository studentRepository;

    private final AcademyRepository academyRepository;

    @Transactional
    public Student registration(StudentRegistration registration) {
        Member findMember = memberRepository.findById(registration.getMemberId())
                .orElseThrow(MemberNotFoundException::new);

        Student student;

        if (registration.getAcademyId() != null) {
            Academy academy = academyRepository.findById(registration.getAcademyId()).orElseThrow(RuntimeException::new);
            student = new AcademyStudent(registration, findMember, academy);
        } else {
            student = new IndividualStudent(registration, findMember);
        }

        return studentRepository.save(student);
    }

}
