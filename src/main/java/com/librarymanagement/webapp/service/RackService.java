package com.librarymanagement.webapp.service;

import com.librarymanagement.webapp.domain.Rack;
import com.librarymanagement.webapp.repository.RackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RackService {

    @Autowired
    private RackRepository repository;
    @Autowired
    private LibraryService libraryService;

    public Rack createRack(Rack rack) {
        Rack newRack = new Rack();
        newRack.setNumber(rack.getNumber());
        newRack.setLocationIdentifier(rack.getLocationIdentifier());
        newRack.setLibrary(libraryService.createLibrary(rack.getLibrary()));
        return repository.save(newRack);
    }
}
