package com.cherr.mov.member;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long, MemberEntity> store = new HashMap<>();

    @Override
    public void save(MemberEntity member) {
        store.put(member.getId(),member);
    }

    @Override
    public MemberEntity findById(Long memberId) {
        return store.get(memberId);
    }
}
