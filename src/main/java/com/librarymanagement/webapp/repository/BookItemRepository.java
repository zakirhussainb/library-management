package com.librarymanagement.webapp.repository;

import com.librarymanagement.webapp.domain.Book;
import com.librarymanagement.webapp.domain.BookItem;
import com.librarymanagement.webapp.util.BookItemStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookItemRepository extends JpaRepository<BookItem, Long> {
    Optional<BookItem> findByBarCode(String barCode);

    List<BookItem> findAllByStatusAndBookTitle(BookItemStatus bookItemStatus, String title);
}
