package com.janek.letsner.infrastructure.academy;

import com.janek.letsner.domain.academy.Academy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AcademyRepository extends JpaRepository<Academy, Long> {
}
