package jieuny.springbasic.member;

import jieuny.springbasic.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.assertThat;

public class MemberServiceTest {
    MemberService memberService;
    @BeforeEach
    void config(){
        AppConfig appConfig= new AppConfig();
        memberService= appConfig.memberService();
    }

    @Test
    void join(){
        Member member= new Member("MemberA", Grade.VIP, 1L);
        
        memberService.join(member);
        Member findmember= memberService.findMember(member.getId());
        assertThat(member).isEqualTo(findmember);
    }
}
