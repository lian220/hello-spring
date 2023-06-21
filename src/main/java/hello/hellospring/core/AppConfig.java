package hello.hellospring.core;

import hello.hellospring.discount.FixDiscountPolicy;
import hello.hellospring.member.MemoryMemberRepository;
import hello.hellospring.order.OrderService;
import hello.hellospring.order.OrderServiceImpl;
import hello.hellospring.service.MemberService;
import hello.hellospring.service.MemberServiceImpl;

public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }
}
