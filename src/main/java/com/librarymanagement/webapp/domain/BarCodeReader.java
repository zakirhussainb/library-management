package com.librarymanagement.webapp.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
public class BarCodeReader {
    private String libraryCardBarCode;
    private String bookItemBarCode;
}
