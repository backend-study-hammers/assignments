package hello.core.member;

import hello.core.AppConfig;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemberServiceImplTest {

    MemberService memberService;

    @BeforeEach
    public void beforeeach(){
        AppConfig appConfig= new AppConfig();
        memberService= appConfig.memberService();
    }

    @Test
    void join(){
        Member member= new Member(1L, "spring",Grade.VIP);
        memberService.join(member);
        Member findmember= memberService.findMember(1L);
        Assertions.assertEquals(member,findmember);

    }

}