package com.tadashboard.enums;

import lombok.Getter;

@Getter
public enum GlobalSettingOptions {
    ADD_PAGE("Add Page"),
    CREATE_PROFILE("Create Profile"),
    CREATE_PANEL("Create Panel"),
    EDIT("Edit"),
    DELETE("Delete");

    private final String value;

    GlobalSettingOptions(String value) {
        this.value = value;
    }
}
