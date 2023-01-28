package com.janek.letsner.response;

import com.janek.letsner.domain.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class MemberResponse {

    private final Long id;
    private final String username;
    private final String name;

    public MemberResponse(Member member) {
        this.id = member.getId();
        this.username = member.getUsername();
        this.name = member.getName();
    }

    @Builder
    public MemberResponse(Long id, String username, String name) {
        this.id = id;
        this.username = username;
        this.name = name;
    }
}
