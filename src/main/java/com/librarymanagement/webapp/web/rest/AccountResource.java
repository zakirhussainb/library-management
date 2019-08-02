package com.librarymanagement.webapp.web.rest;

import com.librarymanagement.webapp.domain.Account;
import com.librarymanagement.webapp.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class AccountResource {

    @Autowired
    private AccountService service;

    @GetMapping("/hello")
    public String helloWorld(){
        return "Hello World";
    }

    @PostMapping("/account/create")
    public ResponseEntity<Void> createAccount(@RequestBody Account newAccount) {
        Account account = service.createAccount(newAccount);
        if(account == null)
            return ResponseEntity.noContent().build();
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(account.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @GetMapping("/accounts")
    public List<Account> listAllAccounts() {
        return service.listAllAccounts();
    }

    @GetMapping("/account/{id}")
    public Account findAccount(@PathVariable Long id) {
        return service.findAccountById(id);
    }
}
