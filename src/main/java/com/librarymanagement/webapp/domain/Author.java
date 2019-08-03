package com.librarymanagement.webapp.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "author")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
}
