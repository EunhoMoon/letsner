package com.janek.letsner.controller;

import com.janek.letsner.domain.Member;
import com.janek.letsner.request.MemberCreate;
import com.janek.letsner.response.MemberResponse;
import com.janek.letsner.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/member")
    public MemberResponse join(MemberCreate memberCreate) {
        return memberService.join(memberCreate);
    }

}
