package com.librarymanagement.webapp.service;

import com.librarymanagement.webapp.domain.LibraryCard;
import com.librarymanagement.webapp.repository.LibraryCardRepository;
import com.librarymanagement.webapp.util.LibUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibraryCardService {

    @Autowired
    private LibraryCardRepository repository;

    public List<LibraryCard> findAll() {
        return repository.findAll();
    }

    public LibraryCard findById(Long id) {
        Optional<LibraryCard> result = repository.findById(id);
        if(!result.isPresent()) {
            throw new IllegalArgumentException("LibraryCard is not present. Please check the library card id");
        }
        return result.get();
    }
}
