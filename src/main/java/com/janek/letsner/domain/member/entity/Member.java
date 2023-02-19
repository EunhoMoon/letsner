package com.janek.letsner.domain.member.entity;

import com.janek.letsner.domain.BaseEntity;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member extends BaseEntity {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String username;

    private String name;

    private String password;

    @Builder
    public Member(Long id, String username, String name, String password, LocalDate createdDate) {
        super(createdDate);
        this.id = id;
        this.username = username;
        this.name = name;
        this.password = password;
    }

}
