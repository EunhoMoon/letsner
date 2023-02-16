package com.janek.letsner.domain.student.repository;

import com.janek.letsner.domain.student.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long>, StudentRepositoryCustom {

}
