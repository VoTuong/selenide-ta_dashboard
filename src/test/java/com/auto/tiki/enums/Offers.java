package com.auto.tiki.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Offers {
    TOP_DEAL("Siêu rẻ"),
    FREE_SHIP("Free ship");

    private final String value;

}
