package com.librarymanagement.webapp.repository;

import com.librarymanagement.webapp.domain.Rack;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RackRepository extends JpaRepository<Rack, Long> {
}
