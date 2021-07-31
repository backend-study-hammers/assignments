package hello.core.singletone;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {

    @Test
    void statefulServiceSingleton() {

        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);

        // Thread A: A 사용자 10000원 주문
        int userAPrice = statefulService1.order("orderA",10000);
        // Thread B: B 사용자 20000원 주문
        int userBPrice =statefulService1.order("orderA",20000);

        // Thread A : 사용자 A 주문 금액 조회 , 이때 기대와 다르게 20000원 출력됨 (공유되는 필드의 값이 변경되었으므로)
//        int price = statefulService1.getPrice();
        System.out.println("price = " + userAPrice);
//        Assertions.assertThat(statefulService1.getPrice()).isEqualTo(20000);
    }

    static class TestConfig {
        @Bean
        public StatefulService statefulService() {
            return new StatefulService();
        }
    }

}