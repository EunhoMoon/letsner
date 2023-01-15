package com.janek.letsner.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;

@Getter
@ToString
public class MemberCreate {

    @NotBlank
    private String name;

    @NotBlank
    private String password;

    public MemberCreate(String name, String password) {
        this.name = name;
        this.password = password;
    }

}
