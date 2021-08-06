package hello.core.order;

import hello.core.discount.FixDiscountPolicy;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class OrderServiceImplTest {
    @Test
    void createorder(){

        MemberRepository memberRepository=new MemoryMemberRepository();
        memberRepository.save(new Member(1L, "itemA", Grade.VIP));
        OrderServiceImpl orderService= new OrderServiceImpl(memberRepository, new FixDiscountPolicy());
        Order order= orderService.createOrder(1L, "itemA",10000);

        Assertions.assertThat(order.getDiscountamountprice()).isEqualTo(1000);
    }
}
