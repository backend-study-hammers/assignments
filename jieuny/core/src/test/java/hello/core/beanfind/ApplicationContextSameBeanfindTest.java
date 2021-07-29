package hello.core.beanfind;

import hello.core.AppConfig;
import hello.core.discount.DiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class ApplicationContextSameBeanfindTest {

    AnnotationConfigApplicationContext ac= new AnnotationConfigApplicationContext(configuration.class);

    @Test
    @DisplayName("타입으로 조회시에 같은 타입이 둘 이상 있으면 중복오류 발생한다.")
    void findbeanByTypeDuplicate(){
        assertThrows(NoUniqueBeanDefinitionException.class, ()->ac.getBean(MemberRepository.class));
        assertThat(ac.getBean("memberRepository1",MemberRepository.class)).isInstanceOf(MemoryMemberRepository.class);
    }
    @Test
    @DisplayName("특정 타입을 모두 조회하기")
    void findAllBeanByType(){
        Map<String, MemberRepository> beansOfType = ac.getBeansOfType(MemberRepository.class);
        for(String key: beansOfType.keySet()){
            System.out.println("key= "+key+ "value= "+beansOfType.get(key));
        }
        System.out.println("beansOfType = " +beansOfType);
        assertThat(beansOfType.size()).isEqualTo(2);
    }
    @Configuration
    static class configuration{

        @Bean
        MemberRepository memberRepository1(){
            return new MemoryMemberRepository();
        }
        @Bean
        MemberRepository memberRepository2(){
            return new MemoryMemberRepository();
        }
    }
}
