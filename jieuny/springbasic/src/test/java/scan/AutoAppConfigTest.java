package scan;

import jieuny.springbasic.AutoAppConfig;
import jieuny.springbasic.member.MemberService;
import jieuny.springbasic.member.MemberServiceImpl;
import jieuny.springbasic.member.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

public class AutoAppConfigTest {
    AnnotationConfigApplicationContext ac= new AnnotationConfigApplicationContext(AutoAppConfig.class);
    @Test
    void basicscan(){
        MemberServiceImpl memberService= ac.getBean(MemberServiceImpl.class);
        assertThat(memberService.getMemberRepository()).isInstanceOf(MemoryMemberRepository.class);
    }
}
