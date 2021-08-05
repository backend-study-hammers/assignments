package jieuny.springbasic.beanfind;

import jieuny.springbasic.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

public class ApplicationContextTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("빈 조회")
    void applicationtest() {
        String[] beannames = ac.getBeanDefinitionNames();
        for (String beanname : beannames) {
            Object bean = ac.getBean(beanname);
            System.out.println("beanname= " + beanname + " object= " + bean);
        }
    }

    @Test
    @DisplayName("애플리케이션 빈 조회")
    void applicationtestonlyapp() {
        String[] beandefinitionnames = ac.getBeanDefinitionNames();
        for (String beanname : beandefinitionnames) {
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanname);
            if (beanDefinition.getRole() == beanDefinition.ROLE_APPLICATION) {
                Object bean = ac.getBean(beanname);
                System.out.println("beanname= " + beanname + " object= " + bean);
            }
        }
    }
}
