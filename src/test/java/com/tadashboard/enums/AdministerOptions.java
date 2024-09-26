package com.tadashboard.enums;

import lombok.Getter;

@Getter
public enum AdministerOptions {
    DATA_PROFILES("Data Profiles"),
    PANELS("Panels");
    private final String value;

    AdministerOptions(String value) {
        this.value = value;
    }
}
