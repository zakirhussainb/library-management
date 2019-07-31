package com.librarymanagement.webapp.domain;

import com.librarymanagement.webapp.util.BookFormat;
import com.librarymanagement.webapp.util.BookStatus;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
public class BookItem extends Book{
    private String barCode;
    private boolean isReferenceOnly;
    private Date borrowed;
    private Date dueDate;
    private double price;
    private BookFormat format;
    private BookStatus status;
    private Date dateOfPurchase;
    private Date publicationDate;
    private Rack placedAt;
}
