package com.librarymanagement.webapp.service;

import com.librarymanagement.webapp.domain.Author;
import com.librarymanagement.webapp.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository repository;

    public List<Author> createAuthor(List<Author> authorList) {
        List<Author> newAuthorList = new ArrayList<>();
        for(Author author : authorList) {
            newAuthorList.add(repository.save(author));
        }
        return newAuthorList;
    }
}
