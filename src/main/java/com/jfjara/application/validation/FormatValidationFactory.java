package com.jfjara.application.validation;

public class FormatValidationFactory {

    public static InputDataFormatValidator build(int totalMowers) {

        BoardDimensionValidator boardDimensionValidator = new BoardDimensionValidator();
        InputDataFormatValidator lastValidator = boardDimensionValidator;
        for (int i = 0; i < totalMowers; i++) {
            StartPositionValidator startPositionValidator = new StartPositionValidator();
            MovementCommandsValidator movementCommandsValidator = new MovementCommandsValidator(startPositionValidator);
            lastValidator.setNextValidator(startPositionValidator);
            lastValidator = movementCommandsValidator;
        }
        return boardDimensionValidator;
    }
}
