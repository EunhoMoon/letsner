package com.janek.letsner.api.user;

import com.janek.letsner.domain.user.User;

public class UserDto {

    public record Create(String username, String password) {

        public User toUser(String encodedPassword) {
            return User.builder()
                .username(this.username)
                .encodedPassword(encodedPassword)
                .build();
        }
    }

}
