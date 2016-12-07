package com.zumgu.repository;

import com.zumgu.domain.Member;

import java.util.List;

/**
 * Created by kanghonggu on 2016-12-07.
 */
public interface MemberRepository {
    Member getMember(Long id);
    List<Member> getAllMember();
    void saveMember(Member member);
}
