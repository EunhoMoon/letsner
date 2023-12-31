package com.janek.letsner.application.facade;

import com.janek.letsner.api.student.StudentDto;
import com.janek.letsner.domain.student.Student;
import com.janek.letsner.domain.student.StudentService;
import com.janek.letsner.domain.user.User;
import com.janek.letsner.domain.user.UserService;
import com.janek.letsner.infrastructure.user.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class UserStudentUseCaseTest {

    @Autowired
    UserStudentUseCase userStudentUseCase;

    @Autowired
    StudentService studentService;

    @Autowired
    UserRepository userRepository;

    User initUser() {
        var user = User.builder()
            .username("test@co.kr")
            .encodedPassword("test1234")
            .build();

        userRepository.save(user);

        return user;
    }

    @Test
    @DisplayName("A new student is created, and successful with the token")
    void createStudent() {
        // given
        var studentCreate = new StudentDto.Create("test", initUser().getToken());

        // when
        var newStudent = userStudentUseCase.createNewUsersStudent(studentCreate);

        // then
//        var findStudent = studentService.getStudentById(newStudent.getId());
//        assertEquals(newStudent.getName(), findStudent.getName());
    }

}