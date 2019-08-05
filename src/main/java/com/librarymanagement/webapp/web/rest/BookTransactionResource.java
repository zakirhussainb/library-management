package com.librarymanagement.webapp.web.rest;

import com.librarymanagement.webapp.domain.*;
import com.librarymanagement.webapp.service.BookTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/api")
public class BookTransactionResource {

    @Autowired
    private BookTransactionService service;

    @PostMapping("/bookTransaction/checkOut")
    private ResponseEntity<Void> checkOutBook(@RequestBody BarCodeReader barCodeReader) {
        BookTransaction bookTransaction = service.checkOutABook(barCodeReader);
        if(bookTransaction == null) {
            return ResponseEntity.noContent().build();
        }
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(bookTransaction.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PostMapping("/bookTransaction/returnBook")
    private ResponseEntity<Void> returnBook(@RequestBody BarCodeReader barCodeReader) {
        BookTransaction bookTransaction = service.returnBook(barCodeReader);
        if(bookTransaction == null) {
            return ResponseEntity.noContent().build();
        }
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(bookTransaction.getId()).toUri();
        return ResponseEntity.created(location).build();
    }
}
