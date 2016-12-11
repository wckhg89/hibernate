package com.zumgu.domain;

import org.joda.time.DateTime;

import javax.persistence.*;

/**
 * Created by 강홍구 on 2016-12-11.
 */
@Entity
public class Content {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name="fk_content_member"))
    private Member member;

    @Lob
    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private DateTime createdAt;


}
