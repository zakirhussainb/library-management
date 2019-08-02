package com.librarymanagement.webapp.web.rest;

import com.librarymanagement.webapp.domain.Address;
import com.librarymanagement.webapp.service.AddressService;
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
public class AddressResource {

    @Autowired
    private AddressService service;

    @PostMapping("/address/create")
    public ResponseEntity<Void> createAddress(@RequestBody Address newAddress) {
        Address address = service.createAddress(newAddress);
        if(address == null) {
            return ResponseEntity.noContent().build();
        }
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(address.getId()).toUri();
        return ResponseEntity.created(location).build();
    }
}
