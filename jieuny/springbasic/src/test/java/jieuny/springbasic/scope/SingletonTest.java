package jieuny.springbasic.scope;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class SingletonTest {
    @Test
    void singletest(){
        AnnotationConfigApplicationContext ac= new AnnotationConfigApplicationContext(single.class);
        single single1= ac.getBean(single.class);
        single single2= ac.getBean(single.class);
        System.out.println("single1 = " + single1);
        System.out.println("single2 = " + single2);
        Assertions.assertThat(single1).isSameAs(single2);
        ac.close();
    }
    @Scope("singleton")
    static class single{
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
