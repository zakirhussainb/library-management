package com.librarymanagement.webapp.repository;

import com.librarymanagement.webapp.domain.BookItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookItemRepository extends JpaRepository<BookItem, Long> {

}
