package hammers.jieuny.service;
import hammers.jieuny.domain.Member;
import hammers.jieuny.repository.MemberRepository;
import hammers.jieuny.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
public class MemberService {
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }
    /**회원가입
     * @param member
     * @return
     */
    public Long join(Member member){

        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();
    }
    /**이름중복회원막기
     * @param member
     */
    private void validateDuplicateMember(Member member) {
        memberRepository.findByname(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 이름입니다."); });
    }
    /**전체회원조회*/
   public List<Member> findMembers(){
       return memberRepository.findAll();
   }
   public Optional<Member> findOne(Long memberId){
       return memberRepository.findById(memberId);
   }
}
