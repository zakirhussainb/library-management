package com.librarymanagement.webapp.service;

import com.librarymanagement.webapp.domain.Book;
import com.librarymanagement.webapp.domain.Rack;
import com.librarymanagement.webapp.repository.RackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RackService {

    @Autowired
    private RackRepository repository;
    @Autowired
    private LibraryService libraryService;

    public Rack createRack(Rack rack) {
        /*Optional<Rack> rack1 = findByLocationIdentifier(rack.getLocationIdentifier());
        if(rack1.isPresent()) {
            return rack1.get();
        }*/
        Rack newRack = new Rack();
        newRack.setNumber(rack.getNumber());
        newRack.setLocationIdentifier(rack.getLocationIdentifier());
        newRack.setLibrary(libraryService.createLibrary(rack.getLibrary()));
        return repository.save(newRack);
    }

    private Optional<Rack> findByLocationIdentifier(String locationIdentifier) {
        return repository.findByLocationIdentifier(locationIdentifier);
    }
}
