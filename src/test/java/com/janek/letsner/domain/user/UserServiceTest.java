package com.janek.letsner.domain.user;

import com.janek.letsner.infrastructure.user.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@Transactional
class UserServiceTest {

    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;

    @Test
    @DisplayName("succeed create new user")
    void userCreateTest() {
        // given
        var userCreate = new UserCreate("test@co.kr", "test1234");

        // when
        userService.signup(userCreate);

        // then
        var findUser = userRepository.findUserByToken(userCreate.getUserToken());
        assertTrue(findUser.isPresent());
    }

}