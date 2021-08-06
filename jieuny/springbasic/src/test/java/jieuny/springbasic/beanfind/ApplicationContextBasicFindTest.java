package jieuny.springbasic.beanfind;

import jieuny.springbasic.AppConfig;
import jieuny.springbasic.member.MemberRepository;
import jieuny.springbasic.member.MemberService;
import jieuny.springbasic.member.MemberServiceImpl;
import jieuny.springbasic.member.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ApplicationContextBasicFindTest {

    AnnotationConfigApplicationContext ac= new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("이름으로 찾기")
    void findByname(){
        MemberService memberService= ac.getBean("memberService", MemberService.class);
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("타입으로 찾기")
    void findByType(){
        MemberService memberService= ac.getBean(MemberService.class);
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("구체 타입으로 찾기")
    void findByType2(){
        MemberService memberService= ac.getBean(MemberServiceImpl.class);
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }
    @Test
    @DisplayName("빈 이름으로 조회x")
    void findBeanByName(){
        //MemberService memberService= ac.getBean("xxxx",MemberService.class);
        assertThrows(NoSuchBeanDefinitionException.class, ()-> ac.getBean("xxxx", MemberService.class));
    }
    AnnotationConfigApplicationContext acc= new AnnotationConfigApplicationContext(samebeantype.class);
    @Test
    @DisplayName("같은 타입을 가진 빈이 두개 이상이면 중복 오류 발생~")
    void findByTypeDuplicate(){
        assertThrows(NoUniqueBeanDefinitionException.class, ()->acc.getBean(MemberRepository.class));
    }
    @Configuration
    static class samebeantype{
        @Bean
        public MemberRepository memberRepository1(){
            return new MemoryMemberRepository();
        }
        @Bean
        public MemberRepository memberRepository2(){
            return new MemoryMemberRepository();
        }
    }
    @Test
    @DisplayName("타입으로 조회했을 때 같은게 두개 이상이라면 이름으로 조회")
    void findsameTypeBeanBYNAME(){
        MemberRepository memberRepository= acc.getBean("memberRepository1", MemberRepository.class);
        assertThat(memberRepository).isInstanceOf(MemberRepository.class);
    }
    @Test
    @DisplayName("특정 타입을 가진 모든 빈 조회")
    void findsametypebean(){
        Map<String, MemberRepository> memberRepository = acc.getBeansOfType(MemberRepository.class);
        for(String key: memberRepository.keySet()){
            System.out.println("key = " + key+" MemberRepository "+ memberRepository.get(key));
        }
        assertThat(memberRepository.size()).isEqualTo(2);
    }

}
