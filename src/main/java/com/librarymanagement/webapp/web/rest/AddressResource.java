package com.librarymanagement.webapp.web.rest;

import com.librarymanagement.webapp.domain.Address;
import com.librarymanagement.webapp.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api")
public class AddressResource {

    @Autowired
    private AddressService service;

    @GetMapping("/address/all")
    private List<Address> listAllAddress() {
        return service.listAllAddress();
    }

    @GetMapping("/address/{id}")
    private Address getOneAddress(@PathVariable Long id){
        return service.findAddressById(id);
    }
}
