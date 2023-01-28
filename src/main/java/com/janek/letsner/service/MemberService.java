package com.janek.letsner.service;

import com.janek.letsner.domain.Member;
import com.janek.letsner.exception.MemberNotFoundException;
import com.janek.letsner.repository.MemberRepository;
import com.janek.letsner.request.MemberCreate;
import com.janek.letsner.response.MemberResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public MemberResponse join(MemberCreate memberCreate) {
        Member member = Member.builder()
                .username(memberCreate.getUsername())
                .name(memberCreate.getName())
                .password(memberCreate.getPassword())
                .build();

        Member savedMember = memberRepository.save(member);
        return MemberResponse.builder()
                .id(savedMember.getId())
                .username(savedMember.getUsername())
                .name(savedMember.getName())
                .build();
    }

    public MemberResponse findOne(Long memberId) {
        Member findMember = memberRepository.findById(memberId).orElseThrow(MemberNotFoundException::new);

        return new MemberResponse(findMember);
    }

    public List<MemberResponse> findAll() {
        return memberRepository.findAll().stream()
                .map(MemberResponse::new)
                .collect(Collectors.toList());
    }

}
