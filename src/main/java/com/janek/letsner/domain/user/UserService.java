package com.janek.letsner.domain.user;

import com.janek.letsner.api.user.UserDto;
import com.janek.letsner.common.exceptions.UserNotFoundException;
import com.janek.letsner.infrastructure.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public User signup(UserDto.Create userCreate) {
        var encodedPassword = userCreate.password();
        var newUser = userCreate.toUser(encodedPassword);

        userRepository.save(newUser);

        return newUser;
    }

    public User getUserByToken(String token) {
        return userRepository.findUserByToken(token)
            .orElseThrow(UserNotFoundException::new);
    }

}
