package com.librarymanagement.webapp.service;

import com.librarymanagement.webapp.domain.Book;
import com.librarymanagement.webapp.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private AuthorService authorService;

    public Book createBook(Book book) {
        Optional<Book> newBook = findByTitle(book.getTitle());
        if(newBook.isPresent()) {
            return newBook.get();
        }
        Book resultBook =  new Book();
        resultBook.setIsbn(book.getIsbn());
        resultBook.setTitle(book.getTitle());
        resultBook.setSubject(book.getSubject());
        resultBook.setPublisher(book.getPublisher());
        resultBook.setLanguage(book.getLanguage());
        resultBook.setNumberOfPages(book.getNumberOfPages());
        resultBook.setAuthors(authorService.createAuthor(book.getAuthors()));
        return bookRepository.save(resultBook);
    }

    private Optional<Book> findByTitle(String bookTitle) {
        return bookRepository.findByTitle(bookTitle);
    }

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    public Book findOneById(Long id) {
        Optional<Book> result = bookRepository.findById(id);
        if(!result.isPresent()) {
            throw new IllegalArgumentException("Book is not present. Please check the book id");
        }
        return result.get();
    }



}
