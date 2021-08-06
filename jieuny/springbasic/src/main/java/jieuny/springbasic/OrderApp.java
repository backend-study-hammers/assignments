package jieuny.springbasic;

import jieuny.springbasic.member.*;
import jieuny.springbasic.order.Order;
import jieuny.springbasic.order.OrderService;
import jieuny.springbasic.order.OrderServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {
    public static void main(String[] args) {
//        AppConfig appConfig= new AppConfig();
//        MemberService memberService= appConfig.memberService();
//        OrderService orderService= appConfig.orderService();
        ApplicationContext applicationContext= new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService=applicationContext.getBean("memberService", MemberService.class);
        OrderService orderService=applicationContext.getBean("orderService", OrderService.class);
        Long memberId= 1L;
        Member member= new Member("memberA", Grade.VIP, memberId);
        memberService.join(member);
        Order order= orderService.createorder(memberId, "itemA", 345600);
        System.out.println("oder= "+order);
        System.out.println(order.CaculatePrice());

    }
}
