package jieuny.springbasic.discount;

import jieuny.springbasic.member.Grade;
import jieuny.springbasic.member.Member;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class FixDiscountPolicy implements DiscountPolicy{
    private int discountprice= 1000;

    @Override
    public int discount(Member member, int price) {
        if(member.getGrade()== Grade.VIP)
            return discountprice;
        else
            return 0;
    }
}
