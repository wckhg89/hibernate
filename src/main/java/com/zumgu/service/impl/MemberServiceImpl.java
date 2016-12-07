package com.zumgu.service.impl;

import com.zumgu.domain.Member;
import com.zumgu.repository.MemberRepository;
import com.zumgu.service.MemberSerivce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by kanghonggu on 2016-12-07.
 */
@Service
@Transactional
public class MemberServiceImpl implements MemberSerivce{

    @Autowired
    MemberRepository memberRepository;

    @Override
    public Member getMember(Long id) {
        return memberRepository.getMember(id);
    }

    @Override
    public List<Member> getAllMember() {
        return memberRepository.getAllMember();
    }

    @Override
    public void saveMember(Member member) {
        memberRepository.saveMember(member);
    }

    @Override
    public void putMember(Member newMember) {
        // 영속 상태 (영속 컨텍스트에 의해서 관리된다.
        Member member = memberRepository.getMember(newMember.getId());

        // 영속 컨텍스트에 의해서 관리되기 때문에 값을 바꾸어주면 쿼리를 캐시한다.
        // 메소드가 끝나면 transaction이 끝나면서 session.flush가 일어나면서 update 쿼리가 반영된다.
        member.update(newMember);


    }

    @Override
    public void deleteMember(Member delMember) {
        Member member = memberRepository.getMember(delMember.getId());

        member.delete(delMember);
    }


}
