package com.janek.letsner.domain.user;

import com.janek.letsner.common.baseobject.BaseEntity;
import com.janek.letsner.common.utils.TokenGenerator;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "users")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends BaseEntity {

    private static final String PREFIX_USER = "USER";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, name = "user_token")
    private String token;

    private String username;

    private String encodedPassword;

    @Builder
    private User(
        String username,
        String encodedPassword
    ) {
        this.token = TokenGenerator.getTokenWithPrefix(PREFIX_USER);
        this.username = username;
        this.encodedPassword = encodedPassword;
    }

}
