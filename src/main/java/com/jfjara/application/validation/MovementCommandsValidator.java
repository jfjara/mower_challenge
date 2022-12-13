package com.jfjara.application.validation;

public class MovementCommandsValidator extends InputDataValidator {

    public MovementCommandsValidator(final InputDataValidator nextValidator) {
        super(nextValidator);
        regex = "^[LRM]+$";
    }


}
