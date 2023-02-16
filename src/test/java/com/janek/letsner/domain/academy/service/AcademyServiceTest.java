package com.janek.letsner.domain.academy.service;

import com.janek.letsner.domain.academy.service.AcademyService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@Transactional
@SpringBootTest
class AcademyServiceTest {

    @Autowired
    AcademyService academyService;

    @Test
    @DisplayName("학원 등록")
    void registrationTest() {
        // given
        String academyName = "테스트";

        // when
        Long testId = academyService.registration(academyName);

        // then
        assertEquals(testId, 1L);
    }

}