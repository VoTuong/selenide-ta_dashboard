package com.tadashboard.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Repository {
    SAMPLE_REPOSITORY("SampleRepository");

    private final String value;
}
