package hello.hellospring.service;

import hello.hellospring.member.Member;

public interface MemberService {

    void join(Member member);

    Member findMember(Long memberId);
}
