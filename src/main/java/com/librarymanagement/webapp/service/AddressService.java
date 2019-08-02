package com.librarymanagement.webapp.service;

import com.librarymanagement.webapp.domain.Address;
import com.librarymanagement.webapp.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    @Autowired
    private AddressRepository repository;

    public Address createAddress(Address address) {
        return repository.save(address);
    }


}
