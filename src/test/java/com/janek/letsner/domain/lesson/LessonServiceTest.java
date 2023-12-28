package com.janek.letsner.domain.lesson;

import com.janek.letsner.api.user.UserDto;
import com.janek.letsner.common.exceptions.ItemNotFoundException;
import com.janek.letsner.domain.user.User;
import com.janek.letsner.infrastructure.lesson.LessonRepository;
import com.janek.letsner.infrastructure.user.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class LessonServiceTest {

    @Autowired
    LessonService lessonService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    LessonRepository lessonRepository;

    User initUser() {
        var userCreate = new UserDto.Create("test@co.kr", "test1234");
        var newUser = userCreate.toUser(userCreate.password());
        userRepository.save(newUser);

        return newUser;
    }

    Lesson initLesson() {
        var newUser = initUser();
        var newLesson = LessonCreate.builder()
            .kind(LessonKind.PRIVATE)
            .type(LessonType.REGULAR)
            .build()
            .toLesson(newUser);
        lessonRepository.save(newLesson);

        return newLesson;
    }

    @Test
    @DisplayName("succeeds when creating new lesson")
    void createNewLesson() {
        // given
        var newUser = initUser();
        var newLesson = LessonCreate.builder()
            .kind(LessonKind.PRIVATE)
            .type(LessonType.REGULAR)
            .build()
            .toLesson(newUser);

        // when
        lessonService.createNewLesson(newLesson);

        // then
        var findLesson = lessonRepository.findByToken(newLesson.getToken()).orElseThrow();
        assertEquals(newLesson.getToken(), findLesson.getToken());
    }

    @Test
    @DisplayName("succeeds when deleting lesson")
    void deleteLesson() {
        // given
        var newLesson = initLesson();

        // when
        lessonService.deleteLessonByToken(newLesson.getToken());

        // then
        var findLesson = lessonRepository.findByToken(newLesson.getToken());
        assertTrue(findLesson.isEmpty());
    }

    @Test
    @DisplayName("delete fails when lesson not found and throw ItemNotFoundException")
    void deleteLessonFailTest() {
        // given
        var lessonToken = UUID.randomUUID().toString();

        // expect
        assertThrows(ItemNotFoundException.class, () -> lessonService.deleteLessonByToken(lessonToken));
    }

    @Test
    @DisplayName("succeeds when getting lesson list by user token")
    void getLessonsByUserToken() {
        // given
        var newUser = initUser();
        var newLesson = LessonCreate.builder()
            .kind(LessonKind.PRIVATE)
            .type(LessonType.REGULAR)
            .build()
            .toLesson(newUser);
        var newLesson2 = LessonCreate.builder()
            .kind(LessonKind.ACADEMY)
            .type(LessonType.REGULAR)
            .build()
            .toLesson(newUser);
        lessonRepository.save(newLesson);
        lessonRepository.save(newLesson2);

        // when
        var findLessons = lessonService.getLessonsByUserToken(newUser.getToken());

        // then
        assertEquals(2, findLessons.size());
    }

}