package com.janek.letsner.domain.user;

import com.janek.letsner.api.user.UserDto;
import com.janek.letsner.common.exceptions.UserNotFoundException;
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
class UserServiceTest {

    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;

    @Test
    @DisplayName("succeeds create new user")
    void userCreateTest() {
        // given
        var userCreate = new UserDto.Create("test@co.kr", "test1234");

        // when
        var signupUser = userService.signup(userCreate);

        // then
        var findUser = userRepository.findUserByToken(signupUser.getToken());
        assertTrue(findUser.isPresent());
        assertEquals("test@co.kr", findUser.get().getUsername());
    }

    @Test
    @DisplayName("fails when user not found throw UserNotFoundException")
    void userFindFailTest() {
        // given
        var userToken = UUID.randomUUID().toString();

        // expect
        assertThrows(UserNotFoundException.class, () -> userService.getUserByToken(userToken));
    }

}