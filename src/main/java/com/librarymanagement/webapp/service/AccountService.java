package com.librarymanagement.webapp.service;

import com.librarymanagement.webapp.domain.Account;
import com.librarymanagement.webapp.domain.LibraryCard;
import com.librarymanagement.webapp.repository.AccountRepository;
import com.librarymanagement.webapp.repository.LibraryCardRepository;
import com.librarymanagement.webapp.util.LibUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class AccountService {
    @Autowired
    private AccountRepository repository;
    @Autowired
    private LibraryCardRepository libraryCardRepository;
    @Autowired
    private LibraryCardService libraryCardService;
    @Autowired
    private PersonService personService;
    private static final LibUtility util = new LibUtility();

    public Account createAccount(Account account) {
        Account newAccount = new Account();
        newAccount.setPerson(personService.createPerson(account.getPerson()));
        newAccount.setLibraryCard(libraryCardService.createLibraryCard());
        newAccount.setPassword(account.getPassword());
        newAccount.setStatus(account.getStatus());
        newAccount.setAccountType(account.getAccountType());
        return repository.save(newAccount);
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

    public Account findAccountByLibraryCard(LibraryCard libraryCard) {
        Optional<Account> account = repository.findByLibraryCard(libraryCard);
        if(!account.isPresent()) {
            throw new IllegalArgumentException("Account is not present. Please check the account id");
        }
        return account.get();
    }

    public void incrementTotalBooksCheckedOut(Account account, int numberOfBooksIssued) {
        account.setBooksIssued(numberOfBooksIssued + 1);
        repository.save(account);
    }

    public void decrementTotalBooksCheckedOut(Account account, int numberOfBooksIssued) {
        account.setBooksIssued(numberOfBooksIssued - 1);
        repository.save(account);
    }
}
