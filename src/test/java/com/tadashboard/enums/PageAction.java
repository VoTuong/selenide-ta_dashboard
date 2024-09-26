package com.tadashboard.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum PageAction {
    ADD_PAGE("Add Page"),
    EDIT_PAGE("Edit"),
    DELETE_PAGE("Delete"),
    CREATE_PROFILE("Create Profile"),
    CREATE_PANEL("Create Panel");

    @Getter
    private final String pageAction;
}
