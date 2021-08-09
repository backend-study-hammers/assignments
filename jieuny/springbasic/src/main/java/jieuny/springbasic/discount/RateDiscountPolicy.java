package jieuny.springbasic.discount;

import jieuny.springbasic.annotation.MainDiscountPolicy;
import jieuny.springbasic.member.Grade;
import jieuny.springbasic.member.Member;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@MainDiscountPolicy
public class RateDiscountPolicy implements DiscountPolicy{
    private int discountrate= 10;
    @Override
    public int discount(Member member, int price) {
        if(member.getGrade()== Grade.VIP)
            return price*discountrate/100;
        else
            return 0;
    }
}
