package jieuny.springbasic.order;

import jieuny.springbasic.annotation.MainDiscountPolicy;
import jieuny.springbasic.discount.DiscountPolicy;
import jieuny.springbasic.member.Member;
import jieuny.springbasic.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


@Component
public class OrderServiceImpl implements OrderService{
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;
    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, @MainDiscountPolicy DiscountPolicy discountPolicy) {
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
