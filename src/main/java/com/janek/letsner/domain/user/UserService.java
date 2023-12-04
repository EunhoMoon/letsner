package com.janek.letsner.domain.user;

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
    public void signup(UserCreate userCreate) {
        var newUser = userCreate.toUser();

        userRepository.save(newUser);
    }

}
