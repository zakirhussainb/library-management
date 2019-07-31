package com.librarymanagement.webapp.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "bar_code_reader")
public class BarCodeReader {

    private static final Long serialVersionUID = -2343243243242432341L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String barCodeId;
    private Date registeredAt;
    private boolean active;
}
