package jieuny.springbasic.discount;

import jieuny.springbasic.member.Member;

public interface DiscountPolicy {

    int discount(Member member, int price );

}
