package com.janek.letsner.api.user;

import com.janek.letsner.common.utils.TokenGenerator;
import com.janek.letsner.domain.user.User;

public class UserDto {

    public record Create(String username, String password) {

        private static final String PREFIX_USER = "USER";

        public User toUser(String encodedPassword) {
            return User.builder()
                .token(TokenGenerator.randomCharacterWithPrefix(PREFIX_USER))
                .username(this.username)
                .encodedPassword(encodedPassword)
                .build();
        }
    }

}
