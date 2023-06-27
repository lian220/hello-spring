package hello.hellospring.scope;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import static org.assertj.core.api.Assertions.assertThat;

public class PrototypeBeanFind {
    @Test
    void protypeBeanFind() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(ProtypeBean.class);

        System.out.println("PrototypeBeanFind.protypeBeanFind1");
        ProtypeBean protypeBean1 = ac.getBean(ProtypeBean.class);
        System.out.println("PrototypeBeanFind.protypeBeanFind2");
        ProtypeBean protypeBean2 = ac.getBean(ProtypeBean.class);
        System.out.println("protypeBean1 = " + protypeBean1);
        System.out.println("protypeBean2 = " + protypeBean2);
        assertThat(protypeBean1).isSameAs(protypeBean2);
        ac.close();
    }

    @Scope("prototype")
    static class ProtypeBean {
        @PostConstruct
        public void init() {
            System.out.println("ProtypeBean.init");
        }

        @PreDestroy
        public void destory() {
            System.out.println("ProtypeBean.destory");
        }
    }
}
