package com.jfjara.application.validation;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class InputDataFormatValidator {

    protected InputDataFormatValidator nextValidator;
    protected String regex;

    public InputDataFormatValidator(final InputDataFormatValidator nextValidator) {
        this.nextValidator = nextValidator;
    }


    public InputDataFormatValidator() {

    }


    public boolean validate(final List<String> textToValidate, int indexToValidate) {
        Pattern pattern = Pattern.compile(regex);
        Matcher mat = pattern.matcher(textToValidate.get(indexToValidate));
        if (mat.matches()) {
            return (nextValidator == null || nextValidator.validate(textToValidate, ++indexToValidate));
        }
        return false;
    }

    public void setNextValidator(final InputDataFormatValidator validator) {
        this.nextValidator = validator;
    }

}
