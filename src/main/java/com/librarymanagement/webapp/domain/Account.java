package com.librarymanagement.webapp.domain;

import com.librarymanagement.webapp.util.AccountStatus;
import com.librarymanagement.webapp.util.AccountType;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@Table(name = "account")
public class Account implements Serializable {

    private static final Long serialVersionUID = -2343243243242432341L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String password;
    private AccountStatus status;
    @OneToOne
    @JoinColumn(name = "person_id")
    private Person person;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "library_card_id")
    private LibraryCard libraryCard;
    private AccountType accountType;
    private Date createdAt = new Date();

}
