package com.librarymanagement.webapp.service;

import com.librarymanagement.webapp.domain.Library;
import com.librarymanagement.webapp.repository.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LibraryService {

    @Autowired
    private LibraryRepository repository;
    @Autowired
    private AddressService addressService;

    public Library createLibrary(Library library) {
        Library newLibrary = new Library();
        newLibrary.setName(library.getName());
        newLibrary.setAddress(addressService.createAddress(library.getAddress()));
        return repository.save(newLibrary);
    }

}
