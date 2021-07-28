package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;

public class Fixdiscountpolicy implements  DiscountPolicy{

    private int discountFixamount= 1000;
    @Override
    public int discount(Member member, int price) {
        if(member.getGrade()== Grade.VIP)
            return discountFixamount;
        else
            return 0;
    }
}
