package com.librarymanagement.webapp.domain;

import com.librarymanagement.webapp.util.AccountStatus;
import lombok.Data;

import javax.persistence.*;

@Entity
@Inheritance
@Data
@Table(name = "account")
public abstract class Account {

    private static final Long serialVersionUID = -2343243243242432341L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String password;
    private AccountStatus status;
    @OneToOne
    private Person person;
//    @OneToOne(targetEntity = LibraryCard.class, mappedBy = "account", fetch = FetchType.EAGER)
    @OneToOne
    @JoinColumn
    private LibraryCard libraryCard;

//    public boolean resetPassword();
}
