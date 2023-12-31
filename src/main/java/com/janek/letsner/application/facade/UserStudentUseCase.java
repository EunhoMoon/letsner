package com.janek.letsner.application.facade;

import com.janek.letsner.api.student.StudentDto;
import com.janek.letsner.common.annotations.UseCase;
import com.janek.letsner.domain.student.Student;
import com.janek.letsner.domain.student.StudentService;
import com.janek.letsner.domain.user.UserService;
import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class UserStudentUseCase {

    private final UserService userService;

    private final StudentService studentService;

    public Student createNewUsersStudent(StudentDto.Create studentCreate) {
        var findUser = userService.getUserByToken(studentCreate.userToken());
        var newStudent = studentCreate.toStudent(findUser);

        return studentService.createStudent(newStudent);
    }

}
