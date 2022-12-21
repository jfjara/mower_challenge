package com.jfjara.application.usecase;

import com.jfjara.application.validation.ValidationFactory;
import com.jfjara.domain.repository.InputRepository;
import com.jfjara.application.validation.InputDataValidator;
import com.jfjara.domain.repository.OutputRepository;

import java.util.List;

public class InputDataUseCase {

    private final InputRepository inputRepository;
    private final OutputRepository outputRepository;

    public InputDataUseCase(final InputRepository inputRepository, final OutputRepository outputRepository) {
        this.inputRepository = inputRepository;
        this.outputRepository = outputRepository;
    }

    public List<String> execute() {
        boolean validationOk = false;
        List<String> result = null;
        while (!validationOk) {
            result = inputRepository.readData();
            InputDataValidator validators = ValidationFactory.build(result.size() - 1);
            validationOk = validators.validate(result, 0);
            if (!validationOk) {
                outputRepository.error("Fields not valid. Try again");
            }
        }
        return result;
    }

}
