package com.cherr.mov.member;

import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;

@Component
public class JpaMemberRepository {
    private final EntityManager em;

    public JpaMemberRepository(EntityManager em) {
        this.em = em;
    }

    public Member save(Member member) {
        em.persist(member);
        return member;
    }

    public Member findById(Long memberId){
        Member member =em.find(Member.class, memberId);
        return member;
    }
}
