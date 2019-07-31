package com.librarymanagement.webapp.service;

import com.librarymanagement.webapp.domain.Librarian;
import com.librarymanagement.webapp.domain.Library;
import com.librarymanagement.webapp.repository.LibrarianRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibrarianService {

    @Autowired
    private LibrarianRepository repository;

    public Librarian createLibrarian(Librarian librarian) {
        return repository.save(librarian);
    }

    public List<Librarian> listAllLibrarians() {
        return repository.findAll();
    }

    public Librarian findLibrarianById(Long id) {
        Optional<Librarian> librarian = repository.findById(id);
        if(!librarian.isPresent()) {
            throw new IllegalArgumentException("Librarian is not present. Please check the librarian id");
        }
        return librarian.get();
    }

}
