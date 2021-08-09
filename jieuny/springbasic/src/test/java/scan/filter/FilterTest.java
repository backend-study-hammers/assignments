package scan.filter;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FilterTest {
    AnnotationConfigApplicationContext ac= new AnnotationConfigApplicationContext(scan.class);
    @Test
    void filter(){
        assertThat(ac.getBean(BeanA.class)).isNotNull();
        assertThrows(NoSuchBeanDefinitionException.class,
                ()->ac.getBean(BeanB.class));
    }
    @Configuration
    @ComponentScan(
            excludeFilters = @Filter(type = FilterType.ANNOTATION, classes = MyExludeFilter.class),
            includeFilters = @Filter(type = FilterType.ANNOTATION, classes = MyIncludeFilter.class)
    )
    static class scan {

    }
}
