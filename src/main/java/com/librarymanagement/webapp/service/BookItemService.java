package com.librarymanagement.webapp.service;

import com.librarymanagement.webapp.domain.BookItem;
import com.librarymanagement.webapp.repository.BookItemRepository;
import com.librarymanagement.webapp.util.LibUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookItemService {
    @Autowired
    private BookItemRepository repository;
    @Autowired
    private static final LibUtility util = new LibUtility();
    @Autowired
    private BookService bookService;

    public BookItem createBookItem(BookItem bookItem) {
        BookItem newBookItem = new BookItem();
        newBookItem.setBarCode(util.generateBarcode());
        newBookItem.setReferenceOnly(bookItem.isReferenceOnly());
        newBookItem.setBorrowedDate(bookItem.getBorrowedDate());
        newBookItem.setDueDate(bookItem.getDueDate());
        newBookItem.setPrice(bookItem.getPrice());
        newBookItem.setFormat(bookItem.getFormat());
        newBookItem.setStatus(bookItem.getStatus());
        newBookItem.setPurchasedDate(bookItem.getPurchasedDate());
        newBookItem.setPublicationDate(bookItem.getPublicationDate());
        newBookItem.setPlacedAt(bookItem.getPlacedAt());
        newBookItem.setBook(bookService.createBook(bookItem.getBook()));
        return repository.save(bookItem);
    }

    public List<BookItem> findAll() {
        return repository.findAll();
    }

    public BookItem findOneById(Long id) {
        Optional<BookItem> result = repository.findById(id);
        if(!result.isPresent()) {
            throw new IllegalArgumentException("BookItem is not present. Please check the book item id");
        }
        return result.get();
    }

}
