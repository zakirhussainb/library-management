package com.librarymanagement.webapp.repository;

import com.librarymanagement.webapp.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface MemberRepository extends AccountRepository<Member> {

}
