package jieuny.springbasic.member;

public interface MemberRepository {
    void save(Member member);
    Member findById(Long Id);
}
