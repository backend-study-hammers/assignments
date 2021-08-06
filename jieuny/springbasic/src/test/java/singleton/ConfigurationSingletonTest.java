package singleton;

import jieuny.springbasic.AppConfig;
import jieuny.springbasic.member.MemberService;
import jieuny.springbasic.member.MemberServiceImpl;
import jieuny.springbasic.order.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

public class ConfigurationSingletonTest {
    AnnotationConfigApplicationContext ac= new AnnotationConfigApplicationContext(AppConfig.class);
    @Test
    @DisplayName("singleton 확인 테스트")
    void singletonmemory() {
        MemberServiceImpl memberService = ac.getBean(MemberServiceImpl.class);
        OrderServiceImpl orderService = ac.getBean(OrderServiceImpl.class);
        assertThat(memberService.getMemberRepository()).isSameAs(orderService.getMemberRepository());
        System.out.println("memberService memberRepository = " + memberService.getMemberRepository());
        System.out.println("orderService memberRepository = " + orderService.getMemberRepository());

    }
}
