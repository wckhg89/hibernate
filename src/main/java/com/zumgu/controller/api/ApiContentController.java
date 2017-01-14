package com.zumgu.controller.api;

import com.zumgu.domain.Content;
import com.zumgu.service.ContentService;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by 강홍구 on 2017-01-14.
 */

@RestController
@RequestMapping("/api/v1/contents")
public class ApiContentController {
    
    private static final Logger logger = LoggerFactory.getLogger(ApiContentController.class);

    @Autowired
    private ContentService contentService;

    @GetMapping("/")
    public ResponseEntity<List<Content>> getContents () {
        List<Content> contents = contentService.getContents();
        // create develop branch 모지ㅁㅁㅁ
        return new ResponseEntity<>(contents, HttpStatus.OK);
    }

    @GetMapping("/{memberId}/after/{date}")
    public ResponseEntity<List<Content>> getContentsOfMemberAfterSpecificDate
            (@PathVariable Long memberId, @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") DateTime date) {
        List<Content> contents = contentService.getContentsOfMemberAfterSpecificDate(memberId, date);

        return new ResponseEntity<>(contents, HttpStatus.OK);
    }

    @GetMapping("/{memberId}")
    public ResponseEntity<List<Content>> getContentsOfMember (@PathVariable Long memberId) {
        List<Content> contents = contentService.getContentsOfMember(memberId);

        return new ResponseEntity<>(contents, HttpStatus.OK);
    }
}
