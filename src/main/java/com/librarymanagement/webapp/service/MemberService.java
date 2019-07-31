package com.librarymanagement.webapp.service;

import com.librarymanagement.webapp.domain.Member;
import com.librarymanagement.webapp.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {

    @Autowired
    private MemberRepository repository;

    public Member createMember(Member member) {
        return repository.save(member);
    }

    public List<Member> findAllMembers() {
        return repository.findAll();
    }

    public Member findMemberById(Long id) {
        Optional<Member> member = repository.findById(id);
        if(!member.isPresent()) {
            throw new IllegalArgumentException("Member is not present. Please check the memberId");
        }
        return member.get();
    }

    /*@Autowired
    private LibraryCardRepository libraryCardRepository;

    public boolean checkIfMemberExists(LibraryCard libraryCard){
        return libraryCardRepository.findByBarCode(libraryCard.getBarCode()).isPresent();
    }*/
}
