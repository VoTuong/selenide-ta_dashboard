package com.auto.tiki.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum LeftMenu {
    BOOKSTORE_TIKI("Nhà Sách Tiki"),
    SPORTS_OUTDOORS("Thể Thao - Dã Ngoại");

    private final String value;

}
