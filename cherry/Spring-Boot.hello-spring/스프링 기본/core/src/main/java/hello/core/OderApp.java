package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.order.OderService;
import hello.core.order.OderServiceImpl;
import hello.core.order.Order;

public class OderApp {

    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        OderService oderService = new OderServiceImpl();

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = oderService.createOrder(memberId, "itemA", 1000);

        System.out.println("order = "+ order);
    }
}
