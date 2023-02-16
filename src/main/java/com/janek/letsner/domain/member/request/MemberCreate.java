package com.janek.letsner.domain.member.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;

@Getter
@ToString
@AllArgsConstructor
public class MemberCreate {

    @NotBlank
    private String username;

    @NotBlank
    private String name;

    @NotBlank
    private String password;

}
