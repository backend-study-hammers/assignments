package hello.core.scope;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Provider;

import static org.assertj.core.api.Assertions.assertThat;

public class SingletonTypeWithProtoType {

    @Test
    void PrototypeTest(){
        AnnotationConfigApplicationContext ac= new AnnotationConfigApplicationContext(prototypeBean.class);
        prototypeBean prototypeBean1= ac.getBean(prototypeBean.class);
        prototypeBean1.addcount();
        prototypeBean prototypeBean2= ac.getBean(prototypeBean.class);
        prototypeBean2.addcount();
        assertThat(prototypeBean1.getCount()).isEqualTo(1);
        assertThat(prototypeBean2.getCount()).isEqualTo(1);
    }
    @Test
    void SingletonClientuseprotorype(){
        AnnotationConfigApplicationContext ac= new AnnotationConfigApplicationContext(ClientBean.class, prototypeBean.class);
        ClientBean clientBean1= ac.getBean(ClientBean.class);
        Assertions.assertThat(clientBean1.logic()).isEqualTo(1);
        ClientBean clientBean2= ac.getBean(ClientBean.class);
        Assertions.assertThat(clientBean2.logic()).isEqualTo(1);
    }

    static class ClientBean{
        @Autowired//생성자 하나기 때문에 생략 가능 , 생성 시점에주입
        /*public ClientBean(prototypeBean prototypeBean) {
            this.prototypeBean = prototypeBean;
        }
        */
        private Provider<prototypeBean> prototypebeanprovider;

        public int logic(){
            prototypeBean prototypeBean= prototypebeanprovider.get();
            prototypeBean.addcount();
            return prototypeBean.getCount();
        }
    }
    @Scope("prototype")
    static class prototypeBean {
        private int count= 0;

        public void addcount(){
            count++;
        }

        public int getCount(){
            return count;
        }
        @PostConstruct
        void init (){
            System.out.println("prototype.init"+ this);
        }
        @PreDestroy
        void destroy(){
            System.out.println("prototype.destroy");
        }
    }


}
