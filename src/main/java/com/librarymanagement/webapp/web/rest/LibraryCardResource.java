package com.librarymanagement.webapp.web.rest;

import com.librarymanagement.webapp.domain.Library;
import com.librarymanagement.webapp.domain.LibraryCard;
import com.librarymanagement.webapp.service.LibraryCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class LibraryCardResource {

    @Autowired
    private LibraryCardService service;

    @GetMapping("/libraryCard/all")
    private List<LibraryCard> findAll() {
        return service.findAll();
    }

    @GetMapping("/libraryCard/{id}")
    private LibraryCard findLibraryCardById(@PathVariable Long id){
        return service.findById(id);
    }
}
