package jieuny.springbasic;

import jieuny.springbasic.member.Grade;
import jieuny.springbasic.member.Member;
import jieuny.springbasic.member.MemberService;
import jieuny.springbasic.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    public static void main(String[] args) {
//        AppConfig appConfig= new AppConfig();
//        MemberService memberService= appConfig.memberService();
        ApplicationContext applicationContext= new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService= applicationContext.getBean("memberService", MemberService.class);
        Member member= new Member("memberA", Grade.VIP, 1L);
        memberService.join(member);
        Member findmember= memberService.findMember(member.getId());
        System.out.println("member = " + member.getName());
        System.out.println("findmember = " + findmember.getName());
    }
}
