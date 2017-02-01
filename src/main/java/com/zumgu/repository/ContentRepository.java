package com.zumgu.repository;

import com.zumgu.domain.Content;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by 강홍구 on 2017-01-14.
 */
@Repository
public class ContentRepository {

    private static final Logger logger = LoggerFactory.getLogger(ContentRepository.class);

    @Autowired
    SessionFactory sessionFactory;

    public List<Content> getContents () {
        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(Content.class);

        List<Content> contents = criteria.list();

        return contents;
    }

    public List<Content> getContentsWhereIn (List<Long> ids) {
        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(Content.class)
                .add(Restrictions.in("id",ids));

        List<Content> contents = criteria.list();

        return contents;
    }

}
