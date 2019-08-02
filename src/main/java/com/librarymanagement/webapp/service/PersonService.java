package com.librarymanagement.webapp.service;

import com.librarymanagement.webapp.domain.Person;
import com.librarymanagement.webapp.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    @Autowired
    private PersonRepository repository;

    public Person createPerson(Person person) {
        return repository.save(person);
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
