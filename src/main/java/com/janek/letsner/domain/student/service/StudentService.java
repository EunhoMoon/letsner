package com.janek.letsner.domain.student.service;

import com.janek.letsner.domain.student.entity.Student;
import com.janek.letsner.domain.student.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    @Transactional
    public Student registration(Student student) {

        return studentRepository.save(student);
    }

}
