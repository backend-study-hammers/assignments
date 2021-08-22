package com.cherr.mov;

import com.cherr.mov.member.MemberEntity;
import com.cherr.mov.member.MemberService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {

    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();

        ApplicationContext applicationContext =new AnnotationConfigApplicationContext(AutoAppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

        MemberEntity member = new MemberEntity(1L, "0000","chaeri93@ewha.com","chaeri");
        memberService.join(member);

        MemberEntity findMember = memberService.findMember(1L);
        System.out.println("new member = "+member.getUsername());
        System.out.println("find member = "+findMember.getUsername());

    }
}
