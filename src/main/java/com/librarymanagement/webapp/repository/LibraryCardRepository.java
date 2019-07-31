package com.librarymanagement.webapp.repository;

import com.librarymanagement.webapp.domain.LibraryCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LibraryCardRepository extends JpaRepository<LibraryCard, Long> {

    Optional<LibraryCard> findByBarCode(String barCode);
}
