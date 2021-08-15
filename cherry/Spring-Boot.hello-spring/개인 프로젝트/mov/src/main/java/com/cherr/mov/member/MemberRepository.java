package com.cherr.mov.member;

public interface MemberRepository {

    void save(MemberEntity member);

    MemberEntity findById(Long memberId);

}
