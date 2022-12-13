package com.jfjara.application.usecase;

import com.jfjara.domain.model.MowerPosition;
import com.jfjara.domain.repository.OutputRepository;

import java.util.List;

public class OutputDataUseCase {

    private final OutputRepository outputRepository;

    public OutputDataUseCase(final OutputRepository outputRepository) {
        this.outputRepository = outputRepository;
    }

    public void execute(final List<MowerPosition> endPositions) {
        outputRepository.show(endPositions);
    }
}
