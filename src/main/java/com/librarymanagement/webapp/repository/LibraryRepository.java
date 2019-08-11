package com.librarymanagement.webapp.repository;

import com.librarymanagement.webapp.domain.Address;
import com.librarymanagement.webapp.domain.Library;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LibraryRepository extends JpaRepository<Library, Long> {
    Optional<Library> findByAddress(Address address);
}
