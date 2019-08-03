package com.librarymanagement.webapp.util;

import java.util.UUID;

public class LibUtility {

    public String generateBarcode() {
        return getUUID();
    }

    public String getUUID() {
        return UUID.randomUUID().toString();
    }
}
