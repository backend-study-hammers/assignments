package jieuny.springbasic;

import jieuny.springbasic.discount.DiscountPolicy;
import jieuny.springbasic.discount.RateDiscountPolicy;
import jieuny.springbasic.member.MemberRepository;
import jieuny.springbasic.member.MemberService;
import jieuny.springbasic.member.MemberServiceImpl;
import jieuny.springbasic.member.MemoryMemberRepository;
import jieuny.springbasic.order.OrderService;
import jieuny.springbasic.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService(){
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl( memberRepository());
    }
    @Bean
    public MemberRepository memberRepository() {
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }
    @Bean
    public OrderService orderService(){
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }
    @Bean
    public DiscountPolicy discountPolicy(){
        return new RateDiscountPolicy();
    }
}
