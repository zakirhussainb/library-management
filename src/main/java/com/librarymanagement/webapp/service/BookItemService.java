package com.librarymanagement.webapp.service;

import com.librarymanagement.webapp.domain.*;
import com.librarymanagement.webapp.repository.BookItemRepository;
import com.librarymanagement.webapp.util.BookItemStatus;
import com.librarymanagement.webapp.util.LibUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookItemService {
    @Autowired
    private BookItemRepository repository;
    private static final LibUtility util = new LibUtility();
    @Autowired
    private BookService bookService;
    @Autowired
    private RackService rackService;

    public BookItem createBookItem(BookItem bookItem) {
        /*Optional<BookItem> bookItem1 = isBookItemExists(bookItem.getBarCode());
        if(bookItem1.isPresent()) {
            return bookItem1.get();
        }*/
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
        newBookItem.setBook(bookService.createBook(bookItem.getBook()));
        newBookItem.setRack(rackService.createRack(bookItem.getRack()));
        return repository.save(newBookItem);
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

    public BookItem findByBarCode(String barCode) {
        Optional<BookItem> result = repository.findByBarCode(barCode);
        if (!result.isPresent()) {
            throw new IllegalArgumentException("BookItem is not present. Please check the book item id");
        }
        return result.get();
    }

    public Optional<BookItem> isBookItemExists(String barCode) {
        return repository.findByBarCode(barCode);
    }

    public void updateBookItemStatus(BookItem bookItem, BookItemStatus bookStatus) {
        bookItem.setStatus(bookStatus);
        repository.save(bookItem);
    }

    public List<BookItem> findAllByStatusAndBook(BookItemStatus available, Book book) {
        return repository.findAllByStatusAndBookTitle(available, book.getTitle());
    }
}
