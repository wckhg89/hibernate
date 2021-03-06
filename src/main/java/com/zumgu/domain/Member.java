package com.zumgu.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import com.google.common.collect.Lists;
import org.joda.time.DateTime;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * Created by kanghonggu on 2016-12-07.
 */
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Member {

    @Id
    @GeneratedValue
    @JsonProperty
    private Long id;

    @Column(unique = true, nullable = false, length = 20)
    @JsonProperty
    private String memberId;

    @Column(nullable = false, length = 20)
    @JsonProperty
    private String password;

    @Column(nullable = false, length = 20)
    @JsonProperty
    private String name;

    @Column(nullable = true, length = 30)
    @JsonProperty
    private String email;

    @JsonProperty
    private Boolean deleted = false;
    @Column(nullable = false)

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "member")
    @JsonIgnore
    private List<Content> contents = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public Member() {
    }

    public Member(Long id, String password, String name, String email) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.email = email;
    }

    public void update(Member newMember) {
        this.name = StringUtils.isEmpty(newMember.name) ? this.name : newMember.name;
        this.password = StringUtils.isEmpty(newMember.password) ? this.password : newMember.password;
        this.email = StringUtils.isEmpty(newMember.email) ? this.email : newMember.email;
    }

    public void delete(Member delMember) {
        this.deleted = delMember.deleted;
    }

    public List<Content> getContents() {
        return contents;
    }

    public List<Content> getContentsAfterSpecificDate (DateTime date) {
        List<Content> specificDateContents = Lists.newArrayList();

        for (Content content : this.contents) {
            if (content.isAfterCreatedDate(date)) {
                specificDateContents.add(content);
            }
        }
        return specificDateContents;
    }
}
