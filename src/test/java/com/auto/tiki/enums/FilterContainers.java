package com.auto.tiki.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;


@Getter
@RequiredArgsConstructor
public enum FilterContainers {
    SERVICE("Dịch vụ"),
    OFFER("Ưu đãi"),
    RATING("Đánh giá"),
    PRICE("Giá"),
    BRAND("Thương hiệu"),
    COLOR("Màu sắc"),
    SUPPLIER("Nhà cung cấp"),
    DELIVERY_TYPE("Giao hàng");

    private final String value;

}
