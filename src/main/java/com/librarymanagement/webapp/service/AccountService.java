package com.librarymanagement.webapp.service;

import com.librarymanagement.webapp.domain.Account;
import com.librarymanagement.webapp.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService {
    @Autowired
    private AccountRepository repository;

    public Account createAccount(Account account) {
        return repository.save(account);
    }

    public List<Account> listAllAccounts() {
        return repository.findAll();
    }

    public Account findAccountById(Long id) {
        Optional<Account> account = repository.findById(id);
        if(!account.isPresent()) {
            throw new IllegalArgumentException("Account is not present. Please check the account id");
        }
        return account.get();
    }
}
