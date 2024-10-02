package com.tadashboard.enums;

import lombok.Getter;

@Getter
public enum GlobalSettingOptions {
    ADD_PAGE("Add Page"),
    DELETE("Delete");

    private final String value;

    GlobalSettingOptions(String value) {
        this.value = value;
    }
}
