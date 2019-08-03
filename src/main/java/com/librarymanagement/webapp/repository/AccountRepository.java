package com.librarymanagement.webapp.repository;

import com.librarymanagement.webapp.domain.Account;
import com.librarymanagement.webapp.domain.LibraryCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    Optional<Account> findByLibraryCard(LibraryCard libraryCard);
}
