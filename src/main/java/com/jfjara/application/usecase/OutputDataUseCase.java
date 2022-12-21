package com.jfjara.application.usecase;

import com.jfjara.domain.model.Mower;
import com.jfjara.domain.repository.OutputRepository;

import java.util.List;

public class OutputDataUseCase {

    private final OutputRepository outputRepository;

    public OutputDataUseCase(final OutputRepository outputRepository) {
        this.outputRepository = outputRepository;
    }

    public void execute(final List<Mower> mowers) {
        outputRepository.show(mowers);
    }
}
