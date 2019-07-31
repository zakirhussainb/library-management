package com.librarymanagement.webapp.domain;


import lombok.Data;

import java.util.List;

@Data
public class Book {

    private String ISBN;
    private String title;
    private String subject;
    private String publisher;
    private String language;
    private int numberOfPages;
    private List<Author> authors;
}
