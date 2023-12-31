package com.janek.letsner.domain.student;

import com.janek.letsner.common.exceptions.ItemNotFoundException;
import com.janek.letsner.infrastructure.student.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class StudentService {

    private final StudentRepository studentRepository;

    @Transactional
    public Student createStudent(Student newStudent) {
        studentRepository.save(newStudent);

        return newStudent;
    }

    public Student getStudentByToken(String studentToken) {
        return studentRepository.findByToken(studentToken)
            .orElseThrow(() -> new ItemNotFoundException("Student not found"));
    }

}
