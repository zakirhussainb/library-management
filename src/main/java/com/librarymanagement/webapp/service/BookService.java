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
        Book newBook = new Book();
        newBook.setIsbn(book.getIsbn());
        newBook.setTitle(book.getTitle());
        newBook.setSubject(book.getSubject());
        newBook.setPublisher(book.getPublisher());
        newBook.setLanguage(book.getLanguage());
        newBook.setNumberOfPages(book.getNumberOfPages());
        newBook.setAuthors(authorService.createAuthor(book.getAuthors()));
        return bookRepository.save(book);
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
