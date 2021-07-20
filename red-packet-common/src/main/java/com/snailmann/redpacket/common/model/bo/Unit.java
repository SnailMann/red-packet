package com.snailmann.redpacket.common.model.bo;

import lombok.Getter;

/**
 * value unit
 */
public enum Unit {
    Cent(1),
    TenCents(10),
    OneHundredCents(100);

    @Getter
    int unit;

    Unit(int unit) {
        this.unit = unit;
    }
}