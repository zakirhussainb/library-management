package com.librarymanagement.webapp.service;

import com.librarymanagement.webapp.domain.Address;
import com.librarymanagement.webapp.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {

    @Autowired
    private AddressRepository repository;

    public Address createAddress(Address address) {
        Optional<Address> address1 = findByStreetAddress(address.getStreetAddress());
        if(address1.isPresent()) {
            return address1.get();
        }
        Address newAddress = new Address();
        newAddress.setStreetAddress(address.getStreetAddress());
        newAddress.setCity(address.getCity());
        newAddress.setState(address.getState());
        newAddress.setCountry(address.getCountry());
        newAddress.setZipCode(address.getZipCode());
        return repository.save(newAddress);
    }

    private Optional<Address> findByStreetAddress(String streetAddress) {
        return repository.findByStreetAddress(streetAddress);
    }

    public List<Address> listAllAddress() {
        return repository.findAll();
    }

    public Address findAddressById(Long id) {
        Optional<Address> result = repository.findById(id);
        if(!result.isPresent()) {
            throw new IllegalArgumentException("Address is not present. Please check the address id");
        }
        return result.get();
    }


}
