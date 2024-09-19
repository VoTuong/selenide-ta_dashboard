package com.tadashboard.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Message {
    LOGIN_INVALID_INFO_ERROR_MESSAGE("Username or password is invalid");

    private final String value;

}
