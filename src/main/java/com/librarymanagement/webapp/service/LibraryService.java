package com.librarymanagement.webapp.service;

import com.librarymanagement.webapp.domain.Address;
import com.librarymanagement.webapp.domain.Library;
import com.librarymanagement.webapp.repository.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LibraryService {

    @Autowired
    private LibraryRepository repository;
    @Autowired
    private AddressService addressService;

    public Library createLibrary(Library library) {
        /*Optional<Library> library1 = findByAddress(library.getAddress());
        if(library1.isPresent()) {
            return library1.get();
        }*/
        Library newLibrary = new Library();
        newLibrary.setName(library.getName());
        newLibrary.setAddress(addressService.createAddress(library.getAddress()));
        return repository.save(newLibrary);
    }

    private Optional<Library> findByAddress(Address address) {
        return repository.findByAddress(address);
    }

}
