package jieuny.springbasic.discount;

import jieuny.springbasic.member.Grade;
import jieuny.springbasic.member.Member;

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
