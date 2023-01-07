package com.janek.letsner.domain;

import lombok.Builder;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Member {

    @Id @GeneratedValue
    private Long id;

    private String name;

    public Member() {
    }

    @Builder
    public Member(Long id, String name) {
        this.id = id;
        this.name = name;
    }

}
