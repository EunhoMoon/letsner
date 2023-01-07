package com.janek.letsner.service;

import com.janek.letsner.domain.Member;
import com.janek.letsner.repository.MemberRepository;
import com.janek.letsner.request.MemberCreate;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public Member join(MemberCreate memberCreate) {
        Member member = Member.builder()
                .name(memberCreate.getName())
                .build();

        return memberRepository.save(member);
    }

}
