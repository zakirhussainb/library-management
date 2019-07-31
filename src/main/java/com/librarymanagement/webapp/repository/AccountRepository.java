package com.librarymanagement.webapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface AccountRepository<T> extends JpaRepository<T, Long> {

}
