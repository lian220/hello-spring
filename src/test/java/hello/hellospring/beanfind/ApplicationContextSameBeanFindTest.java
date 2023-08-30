package hello.hellospring.beanfind;

import hello.hellospring.core.AppConfig;
import hello.hellospring.member.MemberRepository;
import hello.hellospring.member.MemoryMemberRepository;
import hello.hellospring.service.MemberService;
import hello.hellospring.service.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ApplicationContextSameBeanFindTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SameBeanConfig.class);

    @Test
    @DisplayName("타입으로 죄회시 같은 타입으로 둘 이상 있으면, 중복 오류가 발생한다.")
    void findBeanByTypeDuplicate() {
        assertThrows(NoUniqueBeanDefinitionException.class,
                () -> ac.getBean(MemberRepository.class));
    }

    @Test
    @DisplayName("타입으로 죄회시 같은 타입으로 둘 이상 있으면, 중복 오류가 발생한다.")
    void findBeanByName() {
        MemberRepository bean = ac.getBean("memberRepository1", MemberRepository.class);
        assertThat(bean).isInstanceOf(MemberRepository.class);
    }

    @Test
    @DisplayName("타입으로 죄회시 같은 타입으로 둘 이상 있으면, 중복 오류가 발생한다.")
    void findBeanByType() {
        MemberRepository bean = ac.getBean("memberRepository1", MemberRepository.class);
        assertThat(bean).isInstanceOf(MemberRepository.class);
    }

    @Configuration
    static class SameBeanConfig {
        @Bean
        public MemberRepository memberRepository1() {
            return new MemoryMemberRepository();
        }

        @Bean
        public MemberRepository memberRepository2() {
            return new MemoryMemberRepository();
        }
    }

}
