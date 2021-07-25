package hammers.jieuny;

import hammers.jieuny.repository.JpaMemberRepository;
import hammers.jieuny.repository.MemberRepository;
import hammers.jieuny.repository.MemoryMemberRepository;
import hammers.jieuny.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    private final MemberRepository memberRepository;
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository);
    }


}
