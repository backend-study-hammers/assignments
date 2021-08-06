package jieuny.springbasic.discount;

import jieuny.springbasic.member.Grade;
import jieuny.springbasic.member.Member;

public class FixDisountPolicy implements DiscountPolicy{
    private int discountprice= 1000;

    @Override
    public int discount(Member member, int price) {
        if(member.getGrade()== Grade.VIP)
            return discountprice;
        else
            return 0;
    }
}
