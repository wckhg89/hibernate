package com.zumgu.repository.impl;

import com.zumgu.domain.Member;
import com.zumgu.repository.MemberRepository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by kanghonggu on 2016-12-07.
 */
@Repository
public class MemberRepositoryImpl implements MemberRepository {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public Member getMember(Long id) {

        Session session = sessionFactory.getCurrentSession();
        Member member = (Member) session.createCriteria(Member.class)
                            .add(Restrictions.eq("id", id))
                            .uniqueResult();

        return member;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Member> getAllMember() {
        Session session = sessionFactory.getCurrentSession();
        return (List<Member>) session.createCriteria(Member.class).list();
    }

    @Override
    public void saveMember(Member member) {
        Session session = sessionFactory.getCurrentSession();
        session.save(member);
    }

}
