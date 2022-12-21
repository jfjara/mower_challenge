package com.jfjara.domain.model;

import java.util.stream.IntStream;

public enum CardinalDirectionsEnum {
    N("N"), E("E"), S("S"), W("W");

    private String value;

    CardinalDirectionsEnum(String value) {
        this.value = value;
    }

    public String getValueText() {
        return this.value;
    }

    public static int getIndex(final CardinalDirectionsEnum currentCardinalDirection) {
        return IntStream.range(0, CardinalDirectionsEnum.values().length)
                .filter(i -> currentCardinalDirection.equals(CardinalDirectionsEnum.values()[i]))
                .findFirst().getAsInt();
    }

    public CardinalDirectionsEnum rotate(final CardinalDirectionsEnum currentCardinalDirection,
                                                final MowerDirectionsEnum directionToRotate) {

        int index = getIndex(currentCardinalDirection);

        if (directionToRotate == MowerDirectionsEnum.L) {
            index--;
        } else if (directionToRotate == MowerDirectionsEnum.R) {
            index++;
        }

        if (index < 0) {
            index = 3;
        }

        if (index > 3) {
            index = 0;
        }

        return CardinalDirectionsEnum.values()[index];
    }
}

