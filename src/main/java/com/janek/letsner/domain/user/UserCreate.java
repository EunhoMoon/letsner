package com.janek.letsner.domain.user;

import com.janek.letsner.common.utils.TokenGenerator;
import lombok.Getter;

@Getter
public class UserCreate {

    private static final String PREFIX_USER = "USER";

    private final String userToken;

    private final String username;

    private final String encodedPassword;

    public UserCreate(String username, String encodedPassword) {
        this.userToken = TokenGenerator.randomCharacterWithPrefix(PREFIX_USER);
        this.username = username;
        this.encodedPassword = encodedPassword;
    }

    public User toUser() {
        return User.builder()
            .username(this.username)
            .encodedPassword(this.encodedPassword)
            .token(this.userToken)
            .build();
    }

}
