package com.janek.letsner.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@ToString
public class MemberCreate {

    @NotBlank
    private String name;

}
