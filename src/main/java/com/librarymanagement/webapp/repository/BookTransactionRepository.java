package com.librarymanagement.webapp.repository;

import com.librarymanagement.webapp.domain.BookTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookTransactionRepository extends JpaRepository<BookTransaction, Long> {
    Optional<BookTransaction> findByAccountIdAndBookItemId(Long accountId, Long bookItemId);
}
