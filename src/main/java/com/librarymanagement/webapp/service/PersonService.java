package com.librarymanagement.webapp.service;

import com.librarymanagement.webapp.domain.Address;
import com.librarymanagement.webapp.domain.LibraryCard;
import com.librarymanagement.webapp.domain.Person;
import com.librarymanagement.webapp.repository.LibraryCardRepository;
import com.librarymanagement.webapp.repository.PersonRepository;
import com.librarymanagement.webapp.util.LibUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    @Autowired
    private PersonRepository repository;
    @Autowired
    private AddressService addressService;

    public Person createPerson(Person person) {
        /*Optional<Address> address1 = addressService.findByStreetAddress(person.getAddress().getStreetAddress());
        if(address1.isPresent()) {
            return findByAddress(address1.get()).get();
        }*/
        Person newPerson = new Person();
        newPerson.setName(person.getName());
        newPerson.setEmail(person.getEmail());
        newPerson.setPhone(person.getPhone());
        newPerson.setAddress(addressService.createAddress(person.getAddress()));
        return repository.save(newPerson);
    }

    public Optional<Person> findByAddress(Address address) {
        return repository.findByAddress(address);
    }

    public Person findPersonById(Long id) {
        Optional<Person> result = repository.findById(id);
        if(!result.isPresent()) {
            throw  new IllegalArgumentException("Address is not present. Please check the address id");
        }
        return result.get();
    }

    public List<Person> findAll() {
        return repository.findAll();
    }
}
