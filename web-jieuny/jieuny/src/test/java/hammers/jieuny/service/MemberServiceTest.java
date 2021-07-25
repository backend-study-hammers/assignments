package hammers.jieuny.service;
import hammers.jieuny.domain.Member;

import hammers.jieuny.repository.MemoryMemberRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {
    MemberService memberService;
    MemoryMemberRepository memberRepository;
    @BeforeEach
    public void beforeEach(){
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }
    @AfterEach
    public void aftereach(){
        memberRepository.clearStore();
    }
    /**
     * 회원가입
     */
    @Test
    void 회원가입() {
        //given
        Member member= new Member();
        member.setName("hello");
        //when
        Long saveId= memberService.join(member);
        //then
        Member findMember= memberService.findOne(saveId).get();
        assertThat(findMember).isEqualTo(member);
    }
    /**중복회원가입
     *
     */
    @Test
    void 중복_회원_예외() {
        Member member1= new Member();
        Member member2= new Member();
        member1.setName("spring");
        member2.setName("spring");
        memberService.join(member1);
        IllegalStateException e=assertThrows(IllegalStateException.class, ()->memberService.join(member2));
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 이름입니다.");
    }
    @Test
    void findOne() {
    }
}