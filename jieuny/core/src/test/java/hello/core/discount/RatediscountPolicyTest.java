package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RatediscountPolicyTest {

    DiscountPolicy ratediscountpolicy= new RatediscountPolicy();

    @Test
    @DisplayName("VIP는 10% 할인적용한다.")
    void vipo() {
        Member member= new Member(1L, "spring", Grade.VIP);
        int discountaccount= ratediscountpolicy.discount(member, 10000);
        Assertions.assertThat(discountaccount).isEqualTo(1000);
    }
    @Test
    @DisplayName("VIP가 아닌 사람은 10%할인이 안된다.")
    void vipx(){
        Member member=new Member(1L, "spring",Grade.BASIC);
        int discountaccount= ratediscountpolicy.discount(member, 10000);
        Assertions.assertThat(discountaccount).isEqualTo(0);
    }

}