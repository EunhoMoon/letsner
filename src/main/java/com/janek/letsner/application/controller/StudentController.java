package com.janek.letsner.application.controller;

import com.janek.letsner.domain.student.entity.Student;
import com.janek.letsner.domain.student.request.StudentRegistration;
import com.janek.letsner.domain.student.service.StudentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @PostMapping("/registration")
    public Student registration(@RequestBody StudentRegistration registration ) {
        return studentService.registration(registration);
    }

}
