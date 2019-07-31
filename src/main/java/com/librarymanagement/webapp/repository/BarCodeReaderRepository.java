package com.librarymanagement.webapp.repository;

import com.librarymanagement.webapp.domain.BarCodeReader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BarCodeReaderRepository extends JpaRepository<BarCodeReader, Long> {

}
