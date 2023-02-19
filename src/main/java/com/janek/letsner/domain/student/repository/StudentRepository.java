package com.janek.letsner.domain.student.repository;

import com.janek.letsner.domain.student.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long>, StudentRepositoryCustom {

    List<Student> findAllByMemberId(Long memberId);

}
