package com.jfjara.application.validation;

public class StartPositionValidator extends InputDataFormatValidator {

    public StartPositionValidator(final InputDataFormatValidator nextValidator) {
        super(nextValidator);
        regex = "[0-9]*\\s[0-9]*\\s[NSEW]";
    }

    public StartPositionValidator() {
        super();
        regex = "[0-9]*\\s[0-9]*\\s[NSEW]";
    }

}
