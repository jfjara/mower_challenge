package com.jfjara.application.usecase;

import com.jfjara.domain.repository.InputRepository;

import java.util.List;

public class InputDataUseCase {

    private final InputRepository inputRepository;

    public InputDataUseCase(final InputRepository inputRepository) {
        this.inputRepository = inputRepository;
    }

    public List<String> execute(final int totalMowers) {
        return inputRepository.readData(totalMowers);
    }

}
