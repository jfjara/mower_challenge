package com.jfjara.application.validation;

public class MovementCommandsValidator extends InputDataFormatValidator {

    public MovementCommandsValidator(final InputDataFormatValidator nextValidator) {
        super(nextValidator);
        regex = "^[LRM]+$";
    }


}
