package com.janek.letsner.domain.user;

import com.janek.letsner.common.baseobject.BaseEntity;
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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String token;

    private String username;

    private String encodedPassword;

    @Builder
    private User(
        String token,
        String username,
        String encodedPassword
    ) {
        this.token = token;
        this.username = username;
        this.encodedPassword = encodedPassword;
    }

}
