package com.cherr.mov.member;

import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;

@Component
public class JpaMemberRepository {
    private final EntityManager em;

    public JpaMemberRepository(EntityManager em) {
        this.em = em;
    }

    public MemberEntity save(MemberEntity member) {
        em.persist(member);
        return member;
    }

    public MemberEntity findById(Long memberId){
        MemberEntity member =em.find(MemberEntity.class, memberId);
        return member;
    }
}
