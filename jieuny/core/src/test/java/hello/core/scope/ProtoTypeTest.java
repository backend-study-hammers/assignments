package hello.core.scope;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import static org.assertj.core.api.Assertions.assertThat;

public class ProtoTypeTest {
    @Test
    void prototypeBeanFind(){
        AnnotationConfigApplicationContext ac= new AnnotationConfigApplicationContext(prototype.class);
        prototype prototype1= ac.getBean(prototype.class);
        System.out.println("prototypee1 = "+prototype1);
        prototype prototype2= ac.getBean(prototype.class);
        System.out.println("prototype2 = " + prototype2);
        assertThat(prototype1).isNotSameAs(prototype2);
    }
    @Scope("prototype")
    static class prototype{
        @PostConstruct
        void init(){
            System.out.println("prototype.init" );
        }
        @PreDestroy
        void destroy(){
            System.out.println("prototype.destroy");
        }
    }

}
