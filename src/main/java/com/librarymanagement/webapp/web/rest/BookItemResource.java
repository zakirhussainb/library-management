package com.librarymanagement.webapp.web.rest;

import com.librarymanagement.webapp.domain.BookItem;
import com.librarymanagement.webapp.service.BookItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api")
public class BookItemResource {

    @Autowired
    private BookItemService bookItemService;

    @PostMapping("/bookItem/create")
    public ResponseEntity<Void> createBookItem(@RequestBody BookItem bookItem) {
        BookItem newBookItem = bookItemService.createBookItem(bookItem);
        if(newBookItem == null) {
            return ResponseEntity.noContent().build();
        }
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(newBookItem.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @GetMapping("/bookItem/all")
    private List<BookItem> findAll() {
        return bookItemService.findAll();
    }

    @GetMapping("/bookItem/{id}")
    private BookItem findOneById(@PathVariable Long id) {
        return bookItemService.findOneById(id);
    }
}
