package com.jfjara.application.validation;

public class BoardDimensionValidator extends InputDataFormatValidator {

    public BoardDimensionValidator(final InputDataFormatValidator nextValidator) {
        super(nextValidator);
        regex = "[1-9][0-9]*\s[1-9][0-9]*";
    }

    public BoardDimensionValidator() {
        super();
        regex = "[1-9][0-9]*\s[1-9][0-9]*";
    }

}
