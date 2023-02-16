package com.janek.letsner.controller;

import com.janek.letsner.domain.member.request.MemberCreate;
import com.janek.letsner.domain.member.response.MemberResponse;
import com.janek.letsner.domain.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/member")
    public MemberResponse join(@RequestBody MemberCreate memberCreate) {
        return memberService.join(memberCreate);
    }

}
