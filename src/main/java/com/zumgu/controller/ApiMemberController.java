package com.zumgu.controller;

import com.zumgu.domain.Member;
import com.zumgu.service.MemberService;
import com.zumgu.utils.Const;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by kanghonggu on 2016-12-07.
 */
@RestController
@RequestMapping("/api/v1/members")
public class ApiMemberController {

    @Autowired
    private MemberService memberService;

    @ExceptionHandler(value = HibernateException.class)
    public ResponseEntity<String> restException (HibernateException e) {
        return new ResponseEntity<>(Const.UPDATE_FAILED + " : " + e , HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Member> getMember(@PathVariable Long id) {
        Member member = memberService.getMember(id);

        return new ResponseEntity<>(member, HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<List<Member>> getAllMember () {
        List<Member> members = memberService.getAllMember();

        return new ResponseEntity<>(members, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<String> saveMember(@RequestBody Member member) {
        memberService.saveMember(member);

        return new ResponseEntity<>(Const.UPDATE_SUCCESS, HttpStatus.OK);
    }

    @PutMapping("")
    public ResponseEntity<String> putMember(@RequestBody Member member) {
        memberService.putMember(member);

        return new ResponseEntity<>(Const.UPDATE_SUCCESS, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMember(@PathVariable Long id, @RequestBody Member delMember) {
        memberService.deleteMember(delMember);

        return new ResponseEntity<>(Const.UPDATE_SUCCESS, HttpStatus.OK);
    }

}
