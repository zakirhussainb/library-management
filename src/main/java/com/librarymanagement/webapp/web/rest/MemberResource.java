package com.librarymanagement.webapp.web.rest;

import com.librarymanagement.webapp.domain.Account;
import com.librarymanagement.webapp.domain.Member;
import com.librarymanagement.webapp.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(name = "/api")
public class MemberResource {

    @Autowired
    private MemberService memberService;

    @PostMapping("/member/create")
    public ResponseEntity<Void> createMember(@RequestBody Member newMember) {
        Member member = memberService.createMember(newMember);
        if(member == null)
            return ResponseEntity.noContent().build();
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(member.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @GetMapping("/members")
    public List<Member> listAllMembers() {
        return memberService.findAllMembers();
    }

    @GetMapping("/member/{memberId}")
    public Member findMember(@PathVariable Long memberId) {
        return memberService.findMemberById(memberId);
    }

}
