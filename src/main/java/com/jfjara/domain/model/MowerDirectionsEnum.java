package com.jfjara.domain.model;

import java.util.Arrays;

public enum MowerDirectionsEnum {
    L('L'), R('R');

    private final char value;

    MowerDirectionsEnum(final char value) {
        this.value = value;
    }

    public char getValueText() {
        return this.value;
    }

    public static MowerDirectionsEnum fromChar(final char valueText) {
        return Arrays.stream(MowerDirectionsEnum.values())
                .filter(direction ->
                        direction.getValueText() == valueText)
                .findFirst().orElse(null);
    }
}
