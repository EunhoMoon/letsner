package com.janek.letsner.service;

import com.janek.letsner.domain.Academy;
import com.janek.letsner.repository.AcademyRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class AcademyService {

    private final AcademyRepository academyRepository;

    public Long registration(String academyName) {
        Academy savedAcademy = academyRepository.save(new Academy(academyName));

        return savedAcademy.getId();
    }

}
