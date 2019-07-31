package com.librarymanagement.webapp.domain;

import com.librarymanagement.webapp.util.ReservationStatus;
import lombok.Data;

import java.util.Date;

@Data
public class BookReservation {
    private Date creationDate;
    private ReservationStatus status;
    private String bookItemBarcode;
    private String memberId;
}
