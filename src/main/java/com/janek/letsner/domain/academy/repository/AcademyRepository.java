package com.janek.letsner.domain.academy.repository;

import com.janek.letsner.domain.academy.entity.Academy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AcademyRepository extends JpaRepository<Academy, Long> {
}
