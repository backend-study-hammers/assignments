package com.cherr.mov.member;

public interface MemberService {

    void join(MemberEntity member);//회원가입

    MemberEntity findMember(Long memberId);//회원조회
}
