package singleton;

import jieuny.springbasic.AppConfig;
import jieuny.springbasic.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

public class SingleTonTest {
    AppConfig appConfig= new AppConfig();
    @Test
    @DisplayName("순수한 di 컨테이너")
    void puredi(){
        MemberService memberService1= appConfig.memberService();
        MemberService memberService2= appConfig.memberService();
        System.out.println("memberService1 = " + memberService1);
        System.out.println("memberService2 = " + memberService2);
        assertThat(memberService1).isNotSameAs(memberService2);
    }
    @Test
    @DisplayName("싱글톤 직접 만들어서 사용")
    void singleton(){
        SingleTonService singleTonService1= SingleTonService.getinstance();
        SingleTonService singleTonService2= SingleTonService.getinstance();
        System.out.println("singleTonService1 = " + singleTonService1);
        System.out.println("singleTonService2 = " + singleTonService2);
        assertThat(singleTonService1).isSameAs(singleTonService2);
    }
    @Test
    @DisplayName("스프링 싱글톤")
    void springsingleton(){
        AnnotationConfigApplicationContext ac= new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService1= ac.getBean(MemberService.class);
        MemberService memberService2= ac.getBean(MemberService.class);
        System.out.println("memberService1 = " + memberService1);
        System.out.println("memberService2 = " + memberService2);
        assertThat(memberService1).isSameAs(memberService2);
    }
}
