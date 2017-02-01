package com.zumgu.service;

import com.google.common.collect.Lists;

import com.zumgu.domain.Content;
import com.zumgu.domain.Member;
import com.zumgu.repository.ContentRepository;
import com.zumgu.repository.MemberRepository;

import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by 강홍구 on 2017-01-14.
 */
@Service
@Transactional
public class ContentService {

    private static final Logger logger = LoggerFactory.getLogger(ContentService.class);

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private ContentRepository contentRepository;


    public List<Content> getContents () {
        return contentRepository.getContents();
    }

    public List<Content> getContentsOfMember (Long memberId) {
        Member member = memberRepository.getMember(memberId);

        return member.getContents();
    }

    public List<Content> getContentsOfMemberAfterSpecificDate (Long memberId, DateTime date) {
        Member member = memberRepository.getMember(memberId);

        List<Content> specificDateContents = member.getContentsAfterSpecificDate(date);

        return specificDateContents;
    }

    public List<Content> getContentsWhereIn () {
        List<Long> ids = Lists.newArrayList(5L,4L,3L,2L,1L);

        return contentRepository.getContentsWhereIn(ids);
    }
}
