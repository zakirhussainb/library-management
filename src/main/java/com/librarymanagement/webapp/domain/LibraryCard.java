package com.librarymanagement.webapp.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "library_card")
public class LibraryCard {

    private static final Long serialVersionUID = -2343243243242432341L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String barCode;
    private Date issuedAt;
    private boolean active;
}
