package hello.core.scan.filter;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

import static org.assertj.core.api.Assertions.assertThat;

public class ComponentAppFilterTest {

    @Test
    void filterscan(){
        ApplicationContext ac= new AnnotationConfigApplicationContext(ComponentAppfilterTest.class);
        BeanA beanA=ac.getBean("beanA",BeanA.class);
        assertThat(beanA).isNotNull();

        org.junit.jupiter.api.Assertions.assertThrows(
                NoSuchBeanDefinitionException.class,()-> ac.getBean(BeanB.class)
        );
    }
    @Configuration
    @ComponentScan(
            includeFilters = @Filter(type = FilterType.ANNOTATION, classes= MyIncludeComponent.class),
            excludeFilters = @Filter(type = FilterType.ANNOTATION, classes= MyExcludeComponent.class)
    )
    static class ComponentAppfilterTest{

    }

}
