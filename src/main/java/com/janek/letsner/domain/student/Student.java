package com.janek.letsner.domain.student;

import com.janek.letsner.common.baseobject.BaseEntity;
import com.janek.letsner.common.utils.TokenGenerator;
import com.janek.letsner.domain.user.User;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "students")
@NoArgsConstructor(access = lombok.AccessLevel.PROTECTED)
public class Student extends BaseEntity {

    private final static String PREFIX_STUDENT = "STUDENT";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String token;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String name;

    @Builder
    private Student(User user, String name) {
        this.token = TokenGenerator.getTokenWithPrefix(PREFIX_STUDENT);
        this.user = user;
        this.name = name;
    }
}
