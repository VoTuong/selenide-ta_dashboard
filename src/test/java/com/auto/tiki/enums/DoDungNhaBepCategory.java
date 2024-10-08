package com.auto.tiki.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum DoDungNhaBepCategory{
    MAY_SAY_CHEN("Máy sấy chén"),
    MAY_XAY_MAY_EP("Máy xay, máy ép"),
    LO_VI_SONG("Lò vi sóng");

    private final String value;

}
