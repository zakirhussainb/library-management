package com.librarymanagement.webapp.web.rest;

import com.librarymanagement.webapp.domain.Address;
import com.librarymanagement.webapp.domain.Person;
import com.librarymanagement.webapp.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class PersonResource {

    @Autowired
    private PersonService service;

    @GetMapping("/person/all")
    private List<Person> findAll() {
        return service.findAll();
    }

    @GetMapping("/person/{id}")
    private Person findAddressById(@PathVariable Long id) {
        return service.findPersonById(id);
    }

}
