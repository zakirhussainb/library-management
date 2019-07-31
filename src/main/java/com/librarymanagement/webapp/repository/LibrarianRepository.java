package com.librarymanagement.webapp.repository;

import com.librarymanagement.webapp.domain.Librarian;

import javax.transaction.Transactional;

@Transactional
public interface LibrarianRepository extends AccountRepository<Librarian> {

}
