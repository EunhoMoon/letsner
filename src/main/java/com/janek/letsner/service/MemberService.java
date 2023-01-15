package com.janek.letsner.service;

import com.janek.letsner.domain.Member;
import com.janek.letsner.repository.MemberRepository;
import com.janek.letsner.request.MemberCreate;
import com.janek.letsner.response.MemberResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberResponse get(Long memberId) {
        Member findMember = memberRepository.findById(memberId).orElseThrow(RuntimeException::new);

        return new MemberResponse(findMember);
    }

    public Member join(MemberCreate memberCreate) {
        Member member = Member.builder()
                .name(memberCreate.getName())
                .password(memberCreate.getPassword())
                .build();

        return memberRepository.save(member);
    }

}
