package com.jfjara.application.validation;

public class StartPositionValidator extends InputDataValidator {

    public StartPositionValidator(final InputDataValidator nextValidator) {
        super(nextValidator);
        regex = "[0-9]*\\s[0-9]*\\s[NSEW]";
    }

}
