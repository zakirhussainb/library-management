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
    private static final LibUtility util = new LibUtility();

    public Account createAccount(Account account) {
        LibraryCard libraryCard = new LibraryCard();
        libraryCard.setBarCode(util.getUUID());
        libraryCard.setActive(true);
        libraryCard.setIssuedAt(new Date());
        account.setLibraryCard(libraryCardRepository.save(libraryCard));
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
