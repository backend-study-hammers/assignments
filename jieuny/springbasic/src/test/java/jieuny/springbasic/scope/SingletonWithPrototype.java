package jieuny.springbasic.scope;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Provider;

import static org.assertj.core.api.Assertions.assertThat;

public class SingletonWithPrototype {
    @Test
    void protype(){
        AnnotationConfigApplicationContext ac= new AnnotationConfigApplicationContext(single.class, prototype.class);
        single single1= ac.getBean(single.class);
        single single2= ac.getBean(single.class);
        assertThat(single1.logic()).isEqualTo(1);
        assertThat(single2.logic()).isEqualTo(1);
    }
    @Scope("singleton")
    static class single{
        @Autowired
        private Provider<prototype> provider;

        public int logic(){
            prototype prototype1= provider.get();
            prototype1.addcount();
            int count = prototype1.getcount();
            return count;
        }
    }
    @Scope("prototype")
    static class prototype{
        private int count=0;
        public void addcount(){
            count++;
        }
        public int getcount(){
            return count;
        }
        @PostConstruct
        public void init(){
            System.out.println("prototype.init"+this);
        }
        @PreDestroy
        public void destroy(){
            System.out.println("prototype.destroy"+this);
        }
    }
}
