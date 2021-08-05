package jieuny.springbasic.order;

import jieuny.springbasic.discount.DiscountPolicy;
import jieuny.springbasic.member.Member;
import jieuny.springbasic.member.MemberRepository;

public class OrderServiceImpl implements OrderService{
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createorder(Long memberId, String itemname, int itemprice) {
        Member member= memberRepository.findById(memberId);
        int discountprice= discountPolicy.discount(member, itemprice);
        return new Order(memberId, itemname,itemprice, discountprice);
    }

    public MemberRepository getMemberRepository(){
        return this.memberRepository;
    }
}
