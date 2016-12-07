package com.zumgu.service;

import com.zumgu.domain.Member;

import java.util.List;

/**
 * Created by kanghonggu on 2016-12-07.
 */
public interface MemberService {
    Member getMember(Long id);
    List<Member> getAllMember();
    void saveMember(Member member);
    void putMember(Member newMember);
    void deleteMember(Member member);
}
