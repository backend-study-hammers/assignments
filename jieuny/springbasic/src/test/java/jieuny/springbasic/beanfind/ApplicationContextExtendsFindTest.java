package jieuny.springbasic.beanfind;

import jieuny.springbasic.discount.DiscountPolicy;
import jieuny.springbasic.discount.FixDisountPolicy;
import jieuny.springbasic.discount.RateDiscountPolicy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ApplicationContextExtendsFindTest {
    @Configuration
    static class TestConfig{
        @Bean
        DiscountPolicy fixdiscount(){
            return new FixDisountPolicy();
        }
        @Bean
        DiscountPolicy ratediscount(){
            return new RateDiscountPolicy();
        }
    }
    AnnotationConfigApplicationContext at= new AnnotationConfigApplicationContext(TestConfig.class);
    @Test
    @DisplayName("같은 타입 존재시 중복")
    void same(){
        assertThrows(NoUniqueBeanDefinitionException.class, ()-> at.getBean(DiscountPolicy.class));
    }
    @Test
    @DisplayName("같은 타입 존재시 이름으로 검색")
    void searchByname(){
        DiscountPolicy discountPolicy= at.getBean("fixdiscount",DiscountPolicy.class);
        assertThat(discountPolicy).isInstanceOf(DiscountPolicy.class);
    }
    @Test
    @DisplayName("특정 하위 타입으로 검색")//추천 ㄴ
    void find(){
        DiscountPolicy discountPolicy= at.getBean("ratediscount",RateDiscountPolicy.class);
        assertThat(discountPolicy).isInstanceOf(DiscountPolicy.class);
    }
    @Test
    @DisplayName("부모 타입으로 모두 검색")
    void findparent(){
        Map<String, DiscountPolicy> beansOfType = at.getBeansOfType(DiscountPolicy.class);
        assertThat(beansOfType.size()).isEqualTo(2);
        for(String key: beansOfType.keySet()){
            System.out.println(" name = " + key + " object= "+ beansOfType.get(key));
        }
    }
    @Test
    @DisplayName("객체 자식들")
    void findobject(){
        Map<String, Object> beansOfType = at.getBeansOfType(Object.class);
        for(String key: beansOfType.keySet()){
            System.out.println("key = " + key);
        }
        System.out.println(beansOfType.size());
    }
}
