package com.librarymanagement.webapp.web.rest;

import com.librarymanagement.webapp.domain.Librarian;
import com.librarymanagement.webapp.service.LibrarianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(name = "/api")
public class LibrarianResource {

    @Autowired
    private LibrarianService service;

    @PostMapping("/librarian/create")
    public ResponseEntity<Void> createLibrarian(@RequestBody Librarian newLibrarian) {
        Librarian librarian = service.createLibrarian(newLibrarian);
        if(librarian == null)
            return ResponseEntity.noContent().build();
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(librarian.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @GetMapping("/librarians")
    public List<Librarian> listAllLibrarians() {
        return service.listAllLibrarians();
    }

    @GetMapping("/librarian/{id}")
    public Librarian findLibrarian(@PathVariable Long id) {
        return service.findLibrarianById(id);
    }
}
