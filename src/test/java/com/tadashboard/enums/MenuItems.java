package com.tadashboard.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum MenuItems {
    LOG_OUT("Logout");

    private final String value;
}
