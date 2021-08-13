package com.cherr.mov.member;

public interface MemberRepository {

    void save(Member member);

    Member findById(Long memberId);

}
