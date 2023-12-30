package com.janek.letsner.domain.academy;

import com.janek.letsner.infrastructure.academy.AcademyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AcademyService {

    private final AcademyRepository academyRepository;

}
