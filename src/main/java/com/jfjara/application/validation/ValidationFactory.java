package com.jfjara.application.validation;

public class ValidationFactory {

    public static InputDataValidator build() {
        return new BoardDimensionValidator(
                new StartPositionValidator(
                        new MovementCommandsValidator(null)));
    }
}
