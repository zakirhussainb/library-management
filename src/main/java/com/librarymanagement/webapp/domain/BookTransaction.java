package com.librarymanagement.webapp.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "book_transaction")
public class BookTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date createdDate = new Date();
    private Long bookItemId;//elasticsearch
    private Long accountId;//postgres
    private boolean reserved;

}
