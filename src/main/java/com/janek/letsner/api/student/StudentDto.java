package com.janek.letsner.api.student;

import com.janek.letsner.domain.student.Student;
import com.janek.letsner.domain.user.User;

public class StudentDto {

    public record Create(String name, String userToken) {

        public Student toStudent(User user) {
            return Student.builder()
                .user(user)
                .name(name)
                .build();
        }
    }

}
