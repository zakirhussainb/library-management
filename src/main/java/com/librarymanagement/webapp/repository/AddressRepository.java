package com.librarymanagement.webapp.repository;

import com.librarymanagement.webapp.domain.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
    Optional<Address> findByStreetAddress(String streetAddress);
}
