package com.janek.letsner.domain.academy.service;

import com.janek.letsner.domain.academy.repository.AcademyRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Transactional
@SpringBootTest
class AcademyServiceTest {

    @Autowired
    AcademyService academyService;

    @Autowired
    AcademyRepository academyRepository;
    @Test
    @DisplayName("학원 등록")
    void registrationTest() {
        // given
        String academyName = "테스트";

        // when
        Long testId = academyService.registration(academyName);

        // then
        assertEquals(academyRepository.findById(testId).get().getName(), "테스트");
    }

}