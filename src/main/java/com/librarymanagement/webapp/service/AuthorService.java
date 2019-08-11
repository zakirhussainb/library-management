package com.librarymanagement.webapp.service;

import com.librarymanagement.webapp.domain.Author;
import com.librarymanagement.webapp.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository repository;

    public Author[] createAuthor(Author[] authors) {
        Author[] authorArr = new Author[authors.length];
        for(int i = 0; i < authors.length; i++) {
            authorArr[i] = repository.save(authors[i]);
        }
        return authorArr;
    }
}
