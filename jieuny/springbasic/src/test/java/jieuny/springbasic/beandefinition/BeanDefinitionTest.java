package jieuny.springbasic.beandefinition;

import jieuny.springbasic.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeanDefinitionTest {
    AnnotationConfigApplicationContext ac= new AnnotationConfigApplicationContext(AppConfig.class);
    @Test
    @DisplayName("콩 메타정보들")
    void definition(){
        String[] beannames= ac.getBeanDefinitionNames();
        for(String beanname: beannames){
            BeanDefinition beanDefinition= ac.getBeanDefinition(beanname);
            if(beanDefinition.getRole()==BeanDefinition.ROLE_APPLICATION){
                System.out.println("name= "+beanname+" beanDefinition = " + beanDefinition);
            }
        }
    }
}
