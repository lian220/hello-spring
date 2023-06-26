package hello.hellospring.singleton;

import hello.hellospring.core.AppConfig;
import hello.hellospring.member.MemberRepository;
import hello.hellospring.order.OrderServiceImpl;
import hello.hellospring.service.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConfigurationSingletonTest {

    @Test
    void configurationTest() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
        OrderServiceImpl orderService = ac.getBean("orderService", OrderServiceImpl.class);
        MemberRepository memberRepository = ac.getBean("memberRepository", MemberRepository.class);

//        MemberRepository memberRepository1 = memberService.getMemberRepository();
//        MemberRepository memberRepository2 = orderService.getMemberRepository();
//
//        System.out.println("memberService -> memberRepository = " + memberRepository1);
//        System.out.println("orderService -> memberRepository = " + memberRepository2);
//        System.out.println("memberRepository = " + memberRepository);
//
//        Assertions.assertThat(memberRepository1).isSameAs(memberRepository);
//        Assertions.assertThat(memberRepository2).isSameAs(memberRepository);
    }

    @Test
    void configurationDeep() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        AppConfig bean = ac.getBean(AppConfig.class);

        System.out.println("bean = " + bean.getClass());
    }
}
