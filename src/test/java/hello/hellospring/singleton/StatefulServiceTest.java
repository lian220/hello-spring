package hello.hellospring.singleton;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.assertj.core.api.Assertions.assertThat;

class StatefulServiceTest {

    @Test
    void statefulServiceSingeton() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);
//        threadA
        int userAprice = statefulService1.order("userA", 10000);
//        thireadB
        int userBprice = statefulService1.order("userB", 20000);


//        int price = statefulService1.getPrice();
        System.out.println("price = " + userAprice);
        assertThat(userAprice).isNotEqualTo(userBprice);
    }

    static class TestConfig {
        @Bean
        public StatefulService statefulService() {
            return new StatefulService();
        }
    }


}