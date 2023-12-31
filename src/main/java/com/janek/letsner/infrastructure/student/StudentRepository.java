package com.janek.letsner.infrastructure.student;

import com.janek.letsner.domain.student.Student;
import com.janek.letsner.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {

    Optional<Student> findByToken(String token);

}
