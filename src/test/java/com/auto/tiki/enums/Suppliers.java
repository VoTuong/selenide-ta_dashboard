package com.auto.tiki.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Suppliers {
    SUPPLIERS_FAHASA("Nhà sách Fahasa"),
    TIKI_TRADING("Tiki Trading");

    private final String value;

}
