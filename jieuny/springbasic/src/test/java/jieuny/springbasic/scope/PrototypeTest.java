package jieuny.springbasic.scope;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import static org.assertj.core.api.Assertions.assertThat;

public class PrototypeTest {
    @Test
    void prototype(){
        AnnotationConfigApplicationContext ac= new AnnotationConfigApplicationContext(prototype.class);
        System.out.println("bean1");
        prototype bean1= ac.getBean(prototype.class);
        System.out.println("bean2");
        prototype bean2= ac.getBean(prototype.class);
        System.out.println("bean1 = " + bean1);
        System.out.println("bean2 = " + bean2);
        assertThat(bean1).isNotSameAs(bean2);


    }
    @Scope("prototype")
    static class prototype{
        @PostConstruct
        void init(){
            System.out.println("init");
        }
        @PreDestroy
        void destroy(){
            System.out.println("destroy");
        }
    }
}
