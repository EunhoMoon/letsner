package com.janek.letsner.domain.academy.service;

import com.janek.letsner.domain.academy.entity.Academy;
import com.janek.letsner.domain.academy.repository.AcademyRepository;
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
