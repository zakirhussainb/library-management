package com.librarymanagement.webapp.domain;


import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "book")
public class Book implements Serializable {

    private static final Long serialVersionUID = -2343243243242432341L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String isbn;
    private String title;
    private String subject;
    private String publisher;
    private String language;
    private int numberOfPages;
    @ManyToMany(fetch = FetchType.LAZY)
    @Type(type = "com.librarymanagement.webapp.util.GenericArrayUserType")
    @OrderColumn(name = "authors_index")
    @JoinColumn(name = "author_id")
    private Author[] authors;
}
