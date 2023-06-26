package hello.hellospring.scan;

import hello.hellospring.AutoAppConfig;
import hello.hellospring.member.MemberRepository;
import hello.hellospring.order.OrderServiceImpl;
import hello.hellospring.service.MemberService;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

public class AutoAppConfigTest {

    @Test
    void basicScan() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);
        MemberService memberService = ac.getBean(MemberService.class);
        assertThat(memberService).isInstanceOf(MemberService.class);

        OrderServiceImpl bean = ac.getBean(OrderServiceImpl.class);
        MemberRepository memberRepository = bean.getMemberRepository();
        System.out.println("AutoAppConfigTest.basicScan  = " + memberRepository);
    }
}
