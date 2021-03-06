package com.zumgu.controller.api;

import com.zumgu.domain.Member;
import com.zumgu.service.MemberService;
import com.zumgu.utils.Const;
import org.hibernate.HibernateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by kanghonggu on 2016-12-07.
 */
@RestController
@RequestMapping("/api/v1/members")
public class ApiMemberController {

    @Autowired
    private MemberService memberService;

    private static final Logger log = LoggerFactory.getLogger(ApiMemberController.class);

    @GetMapping("/{id}")
    public ResponseEntity<Member> getMember(@PathVariable Long id) {
        Member member = memberService.getMember(id);

        log.error("MSG : {}", "메세지테스트");
        member.getContents().get(0);

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
