package hello.hellospring;

import hello.hellospring.core.AppConfig;
import hello.hellospring.discount.DiscountPolicy;
import hello.hellospring.member.Grade;
import hello.hellospring.member.Member;
import hello.hellospring.member.MemoryMemberRepository;
import hello.hellospring.order.Order;
import hello.hellospring.order.OrderService;
import hello.hellospring.order.OrderServiceImpl;
import hello.hellospring.service.MemberService;
import hello.hellospring.service.MemberServiceImpl;

public class OrderApp {

    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);
        System.out.println("order = " + order);
    }
}
