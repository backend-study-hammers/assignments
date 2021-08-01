package hello.core.scope;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import static org.assertj.core.api.Assertions.assertThat;

public class SingletonTest {
    @Test
    void SingletonBeanfind(){
        AnnotationConfigApplicationContext ac= new AnnotationConfigApplicationContext(SingleBeanTon.class);
        SingleBeanTon singleBeanTon1= ac.getBean(SingleBeanTon.class);
        SingleBeanTon singleBeanTon2= ac.getBean(SingleBeanTon.class);
        System.out.println("singleBeanTon1 = " + singleBeanTon1);
        System.out.println("singleBeanTon2 = " + singleBeanTon2);
        assertThat(singleBeanTon1).isEqualTo(singleBeanTon2);

        ac.close();
    }

    @Scope("singleton")
    static class SingleBeanTon{
        @PostConstruct
        public void init(){
            System.out.println(" SingleBeanTon.init " );
        }
        @PreDestroy
        public void destroy(){
            System.out.println(" SinglBeanTon.destroy");
        }
    }
}
