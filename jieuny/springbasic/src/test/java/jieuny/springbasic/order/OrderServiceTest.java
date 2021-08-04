package jieuny.springbasic.order;

import jieuny.springbasic.AppConfig;
import jieuny.springbasic.member.Grade;
import jieuny.springbasic.member.Member;
import jieuny.springbasic.member.MemberService;
import jieuny.springbasic.member.MemberServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class OrderServiceTest {
    public MemberService memberService;
    public OrderService orderService;

    @BeforeEach
    void config(){
        AppConfig appConfig= new AppConfig();
        memberService= appConfig.memberService();
        orderService= appConfig.orderService();
    }

    @Test
    void createorder(){
        Member member= new Member("jieuny", Grade.VIP, 1L);
        memberService.join(member);
        Order order= orderService.createorder(member.getId(), "heal", 10000);
        assertThat(order.CaculatePrice()).isEqualTo(9000);
    }
}
