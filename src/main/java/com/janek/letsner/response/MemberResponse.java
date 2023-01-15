package com.janek.letsner.response;

import com.janek.letsner.domain.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class MemberResponse {

    private final Long id;
    private final String name;

    public MemberResponse(Member member) {
        this.id = member.getId();
        this.name = member.getName();
    }

    @Builder
    public MemberResponse(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
