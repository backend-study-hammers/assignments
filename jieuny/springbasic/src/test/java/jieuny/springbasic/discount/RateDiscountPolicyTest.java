package jieuny.springbasic.discount;

import jieuny.springbasic.member.Grade;
import jieuny.springbasic.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RateDiscountPolicyTest {
    DiscountPolicy discountPolicy= new RateDiscountPolicy();
    @Test
    @DisplayName("vip는 10프로 할인 받는다")
    void vip_o(){
        Member member= new Member("JIEUNI", Grade.VIP, 1L);
        int discountprice= discountPolicy.discount(member,10000);
        Assertions.assertThat(discountprice).isEqualTo(1000);
    }
    @Test
    @DisplayName("vip가 아니면 10프로 할인 못 받는다")
    void vip_x(){
        Member member= new Member("JIEUNI", Grade.BASIC, 1L);
        int discountprice= discountPolicy.discount(member,10000);
        Assertions.assertThat(discountprice).isEqualTo(0);
    }
}
