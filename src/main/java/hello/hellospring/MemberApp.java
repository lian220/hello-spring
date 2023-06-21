package hello.hellospring;

import hello.hellospring.core.AppConfig;
import hello.hellospring.member.Grade;
import hello.hellospring.member.Member;
import hello.hellospring.service.MemberService;
import hello.hellospring.service.MemberServiceImpl;

public class MemberApp {

    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("member = " + member.getGrade());
        System.out.println("find Member = " + findMember.getName());
    }
}
