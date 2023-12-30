package com.janek.letsner.infrastructure.student;

import com.janek.letsner.domain.student.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
