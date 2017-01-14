package com.zumgu.repository;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by 강홍구 on 2017-01-14.
 */
@Repository
public class ContentRepository {

    private static final Logger logger = LoggerFactory.getLogger(ContentRepository.class);

    @Autowired
    SessionFactory sessionFactory;


}
