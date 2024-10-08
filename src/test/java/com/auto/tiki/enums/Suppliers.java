package com.auto.tiki.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Suppliers {
    DIEN_MAY_ACE("Điện máy ACE"),
    TIKI_TRADING("Tiki Trading");

    private final String value;

}
